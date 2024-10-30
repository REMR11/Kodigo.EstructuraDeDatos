/**
 * Clase inmutable que representa un token de autenticación.
 */
package core.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Token {
    private final String tokenId;
    private final String userId;
    private final String tokenValue;
    private final LocalDateTime creationTime;
    private final LocalDateTime expiryTime;

    public String getAuthorizationHeader() {
        return "Bearer " + tokenValue;
    }

}
