package br.com.CoinTrack.cointrack.exceptions.specializations;

import br.com.CoinTrack.cointrack.exceptions.CoinTrackExceptions;
import org.springframework.http.HttpStatus;

import java.io.Serial;
import java.time.LocalDateTime;
import java.util.List;

public class TransactionNotFound extends CoinTrackExceptions {

    @Serial
    private static final long serialVersionUID = 1L;

    public TransactionNotFound() { }

    public TransactionNotFound(String message, String description) {
        super(message, description, HttpStatus.NOT_FOUND, LocalDateTime.now());
    }

    public TransactionNotFound(List<String> messages, String description) {
        super(messages, description, HttpStatus.NOT_FOUND, LocalDateTime.now());
    }

}
