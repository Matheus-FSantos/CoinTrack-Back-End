package br.com.CoinTrack.cointrack.controllers;

import br.com.CoinTrack.cointrack.dtos.TransactionPutRequestDTO;
import br.com.CoinTrack.cointrack.dtos.TransactionRequestDTO;
import br.com.CoinTrack.cointrack.dtos.TransactionResponseDTO;
import br.com.CoinTrack.cointrack.exceptions.CoinTrackExceptions;
import br.com.CoinTrack.cointrack.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService service;

    @GetMapping
    public ResponseEntity<List<TransactionResponseDTO>> findAll() {
        return ResponseEntity.ok().body(this.service.findAll());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<TransactionResponseDTO>> findAllByUserId(@PathVariable(name="userId") UUID id) {
        return ResponseEntity.ok().body(this.service.findAllByUserId(id));
    }

    @GetMapping("/{transactionId}")
    public ResponseEntity<TransactionResponseDTO> findById(@PathVariable(name="transactionId") UUID id) throws CoinTrackExceptions {
        return ResponseEntity.ok().body(this.service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody TransactionRequestDTO body) throws CoinTrackExceptions {
        this.service.save(body);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{transactionId}")
    public ResponseEntity<Void> save(@PathVariable(name="transactionId") UUID id, @RequestBody TransactionPutRequestDTO body) throws CoinTrackExceptions {
        this.service.updateById(id, body);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{transactionId}")
    public ResponseEntity<Void> deleteById(@PathVariable(name="transactionId") UUID id) throws CoinTrackExceptions {
        this.service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
