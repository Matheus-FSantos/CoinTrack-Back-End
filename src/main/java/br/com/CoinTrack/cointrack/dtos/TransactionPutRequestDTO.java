package br.com.CoinTrack.cointrack.dtos;

import java.math.BigDecimal;
import java.util.UUID;

public record TransactionPutRequestDTO(
    String name,
    BigDecimal total,
    String date,
    Integer type
) { }
