package core.cases;

import application.dtos.AuthenticationResponse;
import core.domain.Token;
import lombok.AllArgsConstructor;
import application.services.TokenManagerSingleton;

@AllArgsConstructor
public class GPTAuthenticator {

    private final TokenManagerSingleton tokenManager;

    public AuthenticationResponse authenticateRequest(String userId) {
        Token token = tokenManager.getToken(userId);
        return new AuthenticationResponse(
                token.getAuthorizationHeader(),
                token.getExpiryTime()
        );
    }
}
