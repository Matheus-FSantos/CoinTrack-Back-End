package br.com.CoinTrack.cointrack.dtos;

import br.com.CoinTrack.cointrack.entities.User;

import java.math.BigDecimal;
import java.util.UUID;

public record TransactionRequestDTO(
    String name,
    BigDecimal total,
    UUID userId,
    String date,
    Integer type
) { }
