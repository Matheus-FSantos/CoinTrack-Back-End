package br.com.CoinTrack.cointrack.services;

import br.com.CoinTrack.cointrack.dtos.LoginRequestDTO;
import br.com.CoinTrack.cointrack.entities.User;
import br.com.CoinTrack.cointrack.exceptions.specializations.InvalidFields;
import br.com.CoinTrack.cointrack.repositories.UserRepository;
import br.com.CoinTrack.cointrack.utils.LoginValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LoginService {

    @Autowired
    private UserRepository repository;

    public UUID login(LoginRequestDTO body) throws InvalidFields {
        /* Fields Validation */
        LoginValidation.validation(body);

        if (this.repository.existsByEmail(body.email())) {
            User user = this.repository.findByEmail(body.email()).get();

            if(user.getPassword().equals(body.password()))
                return user.getId();
        }

        throw new InvalidFields("Invalid Fields.", "Invalid Fields.");
    }

}
