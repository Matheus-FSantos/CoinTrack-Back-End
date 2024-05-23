package br.com.CoinTrack.cointrack.dtos;

import br.com.CoinTrack.cointrack.entities.User;
import br.com.CoinTrack.cointrack.enums.TransactionType;
import br.com.CoinTrack.cointrack.utils.PriceFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record TransactionResponseDTO(
    UUID id,
    String name,
    TransactionType type,
    User user,
    BigDecimal total,
    @JsonFormat(pattern="dd/MM/yyyy") LocalDate date
) {
    @JsonProperty("total")
    public String getTotal() {
        return PriceFormat.priceFormat(total);
    }
}
