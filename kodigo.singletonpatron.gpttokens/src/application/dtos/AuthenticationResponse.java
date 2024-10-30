package application.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class AuthenticationResponse
{
        private String authorizationHeader;
        private LocalDateTime expiryTime;

}
