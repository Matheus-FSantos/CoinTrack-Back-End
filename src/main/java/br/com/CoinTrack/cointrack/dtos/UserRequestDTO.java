package br.com.CoinTrack.cointrack.dtos;

public record UserRequestDTO(
        String name,
        String email,
        String password
) { }
