package br.com.CoinTrack.cointrack.advices;

import br.com.CoinTrack.cointrack.dtos.CoinTrackResponseDTO;
import br.com.CoinTrack.cointrack.exceptions.CoinTrackExceptions;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CoinTrackAdvice {

    @ExceptionHandler(CoinTrackExceptions.class)
    public ResponseEntity<CoinTrackResponseDTO> handleCoinTrackExceptions(CoinTrackExceptions coinTrackExceptions) {
        return ResponseEntity.status(coinTrackExceptions.getStatusCode()).body(
                new CoinTrackResponseDTO(
                        coinTrackExceptions.getMessages(),
                        coinTrackExceptions.getDescription(),
                        coinTrackExceptions.getStatusCode().value(),
                        coinTrackExceptions.getExceptionAt()
                )
        );
    }

}
