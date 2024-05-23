package br.com.CoinTrack.cointrack.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.List;

public record CoinTrackResponseDTO(
        List<String> messages,
        String description,
        Integer statusCode,
        @JsonFormat(pattern="dd/MM/yyyy HH:mm:ss") LocalDateTime exceptionAt
) { }
