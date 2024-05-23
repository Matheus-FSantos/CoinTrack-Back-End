package br.com.CoinTrack.cointrack.controllers;

import br.com.CoinTrack.cointrack.dtos.LoginRequestDTO;
import br.com.CoinTrack.cointrack.exceptions.CoinTrackExceptions;
import br.com.CoinTrack.cointrack.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/login")
public class LoginController {

    @Autowired
    private LoginService service;

    @PostMapping
    public ResponseEntity<UUID> login(@RequestBody LoginRequestDTO body) throws CoinTrackExceptions {
        return ResponseEntity.ok().body(this.service.login(body));
    }


}
