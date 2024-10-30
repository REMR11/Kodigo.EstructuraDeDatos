/**
 * Clase que representa el resultado de la validación de un token.
 */
package core.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Optional;

@Getter
@AllArgsConstructor
public class TokenValidationResult {
    private final boolean valid;
    private final Token token;
    public Optional<Token> getToken() { return Optional.ofNullable(token); }
}
