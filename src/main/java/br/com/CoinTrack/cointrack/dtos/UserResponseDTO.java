package br.com.CoinTrack.cointrack.dtos;

import java.util.UUID;

public record UserResponseDTO(
        UUID id,
        String name,
        String email,
        String password
) { }
