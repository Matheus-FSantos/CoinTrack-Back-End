package br.com.CoinTrack.cointrack.controllers;

import br.com.CoinTrack.cointrack.dtos.UserPutRequestDTO;
import br.com.CoinTrack.cointrack.dtos.UserRequestDTO;
import br.com.CoinTrack.cointrack.dtos.UserResponseDTO;
import br.com.CoinTrack.cointrack.exceptions.CoinTrackExceptions;
import br.com.CoinTrack.cointrack.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> findAll() {
        return ResponseEntity.ok().body(this.service.findAll());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponseDTO> findById(@PathVariable(name="userId") UUID id) throws CoinTrackExceptions {
        return ResponseEntity.ok().body(this.service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody UserRequestDTO body) throws CoinTrackExceptions {
        this.service.save(body);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{userId}")
    public ResponseEntity<Void> update(@PathVariable(name="userId") UUID id, @RequestBody UserPutRequestDTO body) throws CoinTrackExceptions {
        this.service.update(id, body);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteById(@PathVariable(name="userId") UUID id) throws CoinTrackExceptions {
        this.service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
