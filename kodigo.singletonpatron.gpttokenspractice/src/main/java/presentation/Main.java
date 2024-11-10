package presentation;

import application.dtos.AuthenticationResponse;
import application.services.TokenManagerSingleton;
import core.cases.GPTAuthenticator;

public class Main {
    public static void main(String[] args) {
        TokenManagerSingleton tokenManager = TokenManagerSingleton.getInstance();
        // Crear instancias del autenticador
        GPTAuthenticator auth1 = new GPTAuthenticator(tokenManager);
        GPTAuthenticator auth2 = new GPTAuthenticator(tokenManager);

        // Generar token para un usuario
        String userId = "REMR11";
        AuthenticationResponse authResponse = auth1.authenticateRequest(userId);

        System.out.println("Authorization Header: " + authResponse.authorizationHeader());
        System.out.println("Token expira en: " + authResponse.expiryTime());

        // Validar el token
        String tokenValue = authResponse.authorizationHeader();
        TokenManagerSingleton.getInstance()
                .validateToken(tokenValue)
                .ifPresent(result -> {
                    System.out.println("Token válido: " + result.isValid());
                    result.getToken().ifPresent(token ->
                            System.out.println("Usuario: " + token.getUserId()));
                });

        String userId2 = "User1";
        AuthenticationResponse authenticationResponse = auth2.authenticateRequest(userId2);

        System.out.println("Authorization Header: " + authenticationResponse.authorizationHeader());
        System.out.println("Token expira en: " + authenticationResponse.expiryTime());

        String tokenValue2 = authResponse.authorizationHeader().replace("Bearer", "");
        TokenManagerSingleton.getInstance()
                .validateToken(tokenValue2)
                .ifPresent(
                        result2 -> {
                            System.out.println("Token válido: " + result2.isValid());
                            result2.getToken().ifPresent(
                                    token ->
                                            System.out.println("Usuario:" + token.getUserId()));
                        });

    }
}