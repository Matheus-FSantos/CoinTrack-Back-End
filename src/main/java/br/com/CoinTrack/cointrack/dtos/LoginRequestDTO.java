package br.com.CoinTrack.cointrack.dtos;

public record LoginRequestDTO(
        String email,
        String password
) {
}
