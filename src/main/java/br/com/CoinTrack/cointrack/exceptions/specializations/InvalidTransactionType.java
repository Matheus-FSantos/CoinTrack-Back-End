package br.com.CoinTrack.cointrack.exceptions.specializations;

import br.com.CoinTrack.cointrack.exceptions.CoinTrackExceptions;
import org.springframework.http.HttpStatus;

import java.io.Serial;
import java.time.LocalDateTime;
import java.util.List;

public class InvalidTransactionType extends CoinTrackExceptions {

    @Serial
    private static final long serialVersionUID = 1L;

    public InvalidTransactionType() { }

    public InvalidTransactionType(String message, String description) {
        super(message, description, HttpStatus.UNPROCESSABLE_ENTITY, LocalDateTime.now());
    }

    public InvalidTransactionType(List<String> messages, String description) {
        super(messages, description, HttpStatus.UNPROCESSABLE_ENTITY, LocalDateTime.now());
    }

}
