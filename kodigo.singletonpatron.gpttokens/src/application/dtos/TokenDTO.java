package application.dtos;

import java.time.LocalDateTime;

public record TokenDTO(
        String          tokenId,
        String          userId,
        String          tokenValue,
        LocalDateTime   creationTime,
        LocalDateTime   expiryTime
) {}
