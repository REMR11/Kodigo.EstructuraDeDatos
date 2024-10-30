import application.dtos.AuthenticationResponse;
import application.services.TokenManagerSingleton;
import presentation.GPTAuthenticator;

public class Main {
    public static void main(String[] args) {
        TokenManagerSingleton tokenManager = TokenManagerSingleton.getInstance();
        // Crear instancias del autenticador
        GPTAuthenticator auth1 = new GPTAuthenticator(tokenManager);
        GPTAuthenticator auth2 = new GPTAuthenticator(tokenManager);

        // Generar token para un usuario
        String userId = "user123";
        AuthenticationResponse authResponse = auth1.authenticateRequest(userId);

        System.out.println("Authorization Header: " + authResponse.getAuthorizationHeader());
        System.out.println("Token expira en: " + authResponse.getExpiryTime());

        // Validar el token
        String tokenValue = authResponse.getAuthorizationHeader().replace("Bearer ", "");
        TokenManagerSingleton.getInstance()
                .validateToken(tokenValue)
                .ifPresent(result -> {
                    System.out.println("Token válido: " + result.isValid());
                    result.getToken().ifPresent(token ->
                            System.out.println("Usuario: " + token.getUserId()));
                });
    }
}