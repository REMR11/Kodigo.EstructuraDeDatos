/**
 * Gestor de tokens para autenticación con GPT implementando el patrón Singleton.
 * Thread-safe y con manejo de expiración de tokens.
 */
package application.services;

import core.domain.Token;
import core.domain.TokenValidationResult;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class TokenManagerSingleton {
    private static volatile TokenManagerSingleton instance;
    private volatile Token currentToken;
    private final Map<String, Token> revokedTokens;

    private TokenManagerSingleton() {
        String secretKey = generateSecretKey();
        this.revokedTokens = new ConcurrentHashMap<>();
    }

    /***
     * Obtiene la instancia única del gestor de tokens.
     * Implementa el patrón de doble verificación para thread-safety.
     *
     * @return TokenManagerSingleton instancia actual del sistema.
     */
    public static TokenManagerSingleton getInstance() {
        if (instance == null) {
            synchronized (TokenManagerSingleton.class) {
                if (instance == null)
                    instance = new TokenManagerSingleton();
            }
        }
        return instance;
    }

    /***
     * Genera una clave secreta aleatoria para la firma de tokens.
     * @return
     */
    private String generateSecretKey() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] key = new byte[ 32 ]; //11111111 //255
        secureRandom.nextBytes( key );
        return Base64.getEncoder().encodeToString( key );
    }

    /***
     * Obtiene un token válido para el usuario especificado.
     * @param userId
     * @return token verificado y valido al usuario.
     */
    public synchronized Token getToken( String userId ) {
        if (isTokenValid(currentToken)) {
            return currentToken;
        }
        return generateNewToken(userId);
    }

    /***
     * Genera un nuevo token para el usuario especificado.
     * @param userId
     * @return token generado.
     */
    private Token generateNewToken( String userId ) {
        String tokenId = UUID.randomUUID().toString();
        LocalDateTime now = LocalDateTime.now();
        // 1 hora
        long TOKEN_DURATION_MINUTES = 60;
        LocalDateTime expiryTime = now.plusMinutes(TOKEN_DURATION_MINUTES);

        Token token = new Token( tokenId, userId, generateTokenValue(), now, expiryTime );

        currentToken = token;
        return token;
    }

    /***
     * Genera un valor aleatorio para el token.
     *
     * @return valor random codigicado a base64 url-safe.
     */
    private String generateTokenValue() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] tokenBytes = new byte[ 32 ];
        secureRandom.nextBytes( tokenBytes );
        return Base64.getUrlEncoder().withoutPadding().encodeToString(tokenBytes);
    }

    /***
     * Verifica si un token es válido.
     *
     * @param token
     * @return boolean que verifica que el token sea valido.
     */
    private boolean isTokenValid( Token token ) {
        if ( token == null ) {
            return false;
        }

        LocalDateTime now = LocalDateTime.now();
        // Añadimos un margen de seguridad de 5 minutos
        LocalDateTime effectiveExpiry = token.getExpiryTime().minusMinutes(5);

        return now.isBefore( effectiveExpiry )
                && !revokedTokens.containsKey( token.getTokenId() );
    }

    /**
     * Revoca un token específico.
     *
     * @param tokenId
     */
    public void revokeToken( String tokenId ) {
        if ( currentToken != null && currentToken.getTokenId().equals( tokenId ) ) {
            revokedTokens.put( tokenId, currentToken );
            currentToken = null;
        }
    }

    /***
     * Valida un token y retorna su información si es válido.
     * @param tokenValue
     * @return  TokenValidationResult en caso de que la informacion sea valida
     */
    public Optional<TokenValidationResult> validateToken ( String tokenValue ) {
        if ( currentToken != null && currentToken.getTokenValue().equals( tokenValue ) ) {
            if (isTokenValid(currentToken)) {
                return Optional.of( new TokenValidationResult( true, currentToken ) );
            }
        }
        return Optional.of( new TokenValidationResult( false, null) );
    }
}