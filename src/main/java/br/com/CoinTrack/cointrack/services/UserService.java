package br.com.CoinTrack.cointrack.services;

import br.com.CoinTrack.cointrack.dtos.UserPutRequestDTO;
import br.com.CoinTrack.cointrack.dtos.UserRequestDTO;
import br.com.CoinTrack.cointrack.dtos.UserResponseDTO;
import br.com.CoinTrack.cointrack.entities.User;
import br.com.CoinTrack.cointrack.exceptions.specializations.InvalidFields;
import br.com.CoinTrack.cointrack.exceptions.specializations.UserAlreadyExists;
import br.com.CoinTrack.cointrack.exceptions.specializations.UserNotFound;
import br.com.CoinTrack.cointrack.repositories.UserRepository;
import br.com.CoinTrack.cointrack.utils.UserValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<UserResponseDTO> findAll() {
        return this.repository.findAll().stream()
            .map(user ->
                    new UserResponseDTO(
                        user.getId(),
                        user.getName(),
                        user.getEmail(),
                        user.getPassword()
            ))
            .collect(Collectors.toList());
    }

    public UserResponseDTO findById(UUID id) throws UserNotFound {
        return this.repository.findById(id).map(user ->
                new UserResponseDTO(
                    user.getId(),
                    user.getName(),
                    user.getEmail(),
                    user.getPassword()
                )
            ).orElseThrow(() -> new UserNotFound("User not found.", "User not found."));
    }

    public void save(UserRequestDTO body) throws InvalidFields, UserAlreadyExists {
        /* Fields Validation */
        UserValidation.validation(body);

        if(this.repository.existsByEmail(body.email()))
            throw new UserAlreadyExists("User already exists.", "User already exists.");
        else {
            User newUser = new User(body.name(), body.email(), body.password());
            this.repository.save(newUser);
        }
    }

    public void update(UUID id, UserPutRequestDTO body) throws InvalidFields, UserAlreadyExists, UserNotFound {
        /* Fields Validation */
        UserValidation.validationWithoutEmail(body);

        if(this.repository.existsById(id)) {
            User oldUser = this.repository.findById(id).get();
            oldUser.updateName(body.name());
            oldUser.updatePassword(body.password());
            this.repository.save(oldUser);
        } else
            throw new UserNotFound("User not found.", "User not found.");
    }

    public void deleteById(UUID id) throws UserNotFound {
        if(this.repository.existsById(id))
            this.repository.deleteById(id);
        else
            throw new UserNotFound("User not found.", "User not found.");
    }

}
