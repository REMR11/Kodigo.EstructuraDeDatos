package application.dtos;

import java.time.LocalDateTime;

public record AuthenticationResponse(
        String          authorizationHeader,
        LocalDateTime   expiryTime
){}
