package application.services;

import core.domain.Token;
import core.domain.TokenValidationResult;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Gestor de tokens para autenticación con GPT implementando el patrón Singleton.
 * Thread-safe y con manejo de expiración de tokens.
 */
public class TokenManagerSingleton {
    private static volatile TokenManagerSingleton instance;
    private final String secretKey;
    private volatile Token currentToken;
    private final long TOKEN_DURATION_MINUTES = 60; // 1 hora
    private final Map<String, Token> revokedTokens;

    private TokenManagerSingleton() {
        this.secretKey = generateSecretKey();
        this.revokedTokens = new ConcurrentHashMap<>();
    }

    /**
     * Obtiene la instancia única del gestor de tokens.
     * Implementa el patrón de doble verificación para thread-safety.
     */
    public static TokenManagerSingleton getInstance() {
        if (instance == null) {
            synchronized (TokenManagerSingleton.class) {
                if (instance == null) {
                    instance = new TokenManagerSingleton();
                }
            }
        }
        return instance;
    }

    /**
     * Genera una clave secreta aleatoria para la firma de tokens.
     */
    private String generateSecretKey() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] key = new byte[32];
        secureRandom.nextBytes(key);
        return Base64.getEncoder().encodeToString(key);
    }

    /**
     * Obtiene un token válido para el usuario especificado.
     */
    public synchronized Token getToken(String userId) {
        if (isTokenValid(currentToken)) {
            return currentToken;
        }
        return generateNewToken(userId);
    }

    /**
     * Genera un nuevo token para el usuario especificado.
     */
    private Token generateNewToken( String userId ) {
        String tokenId = UUID.randomUUID().toString();
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime expiryTime = now.plus( TOKEN_DURATION_MINUTES, ChronoUnit.MINUTES );

        Token token = new Token( tokenId, userId, generateTokenValue(), now, expiryTime );

        currentToken = token;
        return token;
    }
    

    /**
     * Genera un valor aleatorio para el token.
     */
    private String generateTokenValue() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] tokenBytes = new byte[ 32 ];
        secureRandom.nextBytes( tokenBytes );
        return Base64.getUrlEncoder().withoutPadding().encodeToString(tokenBytes);
    }

    /**
     * Verifica si un token es válido.
     */
    private boolean isTokenValid( Token token ) {
        if ( token == null ) {
            return false;
        }

        LocalDateTime now = LocalDateTime.now();
        // Añadimos un margen de seguridad de 5 minutos
        LocalDateTime effectiveExpiry = token.getExpiryTime().minus( 5, ChronoUnit.MINUTES );

        return now.isBefore( effectiveExpiry )
                && !revokedTokens.containsKey( token.getTokenId() );
    }

    /**
     * Revoca un token específico.
     */
    public void revokeToken( String tokenId ) {
        if ( currentToken != null && currentToken.getTokenId().equals( tokenId ) ) {
            revokedTokens.put( tokenId, currentToken );
            currentToken = null;
        }
    }

    /**
     * Valida un token y retorna su información si es válido.
     */
    public Optional<TokenValidationResult> validateToken(String tokenValue) {
        if ( currentToken != null && currentToken.getTokenValue().equals( tokenValue ) ) {
            if (isTokenValid(currentToken)) {
                return Optional.of( new TokenValidationResult( true, currentToken ) );
            }
        }
        return Optional.of( new TokenValidationResult( false, null) );
    }
}