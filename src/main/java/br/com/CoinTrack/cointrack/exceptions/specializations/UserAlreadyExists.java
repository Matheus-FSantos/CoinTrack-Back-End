package br.com.CoinTrack.cointrack.exceptions.specializations;

import br.com.CoinTrack.cointrack.exceptions.CoinTrackExceptions;
import org.springframework.http.HttpStatus;

import java.io.Serial;
import java.time.LocalDateTime;
import java.util.List;

public class UserAlreadyExists extends CoinTrackExceptions {

    @Serial
    private static final long serialVersionUID = 1L;

    public UserAlreadyExists() { }

    public UserAlreadyExists(String message, String description) {
        super(message, description, HttpStatus.CONFLICT, LocalDateTime.now());
    }

    public UserAlreadyExists(List<String> messages, String description) {
        super(messages, description, HttpStatus.CONFLICT, LocalDateTime.now());
    }

}
