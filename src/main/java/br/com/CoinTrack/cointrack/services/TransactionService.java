package br.com.CoinTrack.cointrack.services;

import br.com.CoinTrack.cointrack.dtos.TransactionPutRequestDTO;
import br.com.CoinTrack.cointrack.dtos.TransactionRequestDTO;
import br.com.CoinTrack.cointrack.dtos.TransactionResponseDTO;
import br.com.CoinTrack.cointrack.entities.Transaction;
import br.com.CoinTrack.cointrack.entities.User;
import br.com.CoinTrack.cointrack.exceptions.specializations.InvalidFields;
import br.com.CoinTrack.cointrack.exceptions.specializations.TransactionNotFound;
import br.com.CoinTrack.cointrack.exceptions.specializations.UserNotFound;
import br.com.CoinTrack.cointrack.repositories.TransactionRepository;
import br.com.CoinTrack.cointrack.repositories.UserRepository;
import br.com.CoinTrack.cointrack.utils.DateEntityMapper;
import br.com.CoinTrack.cointrack.utils.TransactionValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository repository;

    @Autowired
    private UserRepository userRepository;

    public List<TransactionResponseDTO> findAll() {
        return this.repository.findAll().stream()
            .map(transaction -> new TransactionResponseDTO(
                    transaction.getId(),
                    transaction.getName(),
                    transaction.getMethod(),
                    transaction.getType(),
                    transaction.getUser(),
                    transaction.getTotal(),
                    transaction.getDate()
            ))
            .collect(Collectors.toList());
    }

    public List<TransactionResponseDTO> findAllByUserId(UUID id) {
        return this.repository.findByUserId(id).stream()
            .map(transaction -> new TransactionResponseDTO(
                    transaction.getId(),
                    transaction.getName(),
                    transaction.getMethod(),
                    transaction.getType(),
                    transaction.getUser(),
                    transaction.getTotal(),
                    transaction.getDate()
            ))
            .collect(Collectors.toList());
    }

    public TransactionResponseDTO findById(UUID id) throws TransactionNotFound {
        return this.repository.findById(id).map(transaction ->
            new TransactionResponseDTO(
                    transaction.getId(),
                    transaction.getName(),
                    transaction.getMethod(),
                    transaction.getType(),
                    transaction.getUser(),
                    transaction.getTotal(),
                    transaction.getDate()
            )
        ).orElseThrow(() -> new TransactionNotFound("Transaction not found.", "Transaction not found."));
    }

    public void save(TransactionRequestDTO body) throws InvalidFields, UserNotFound {
        /* Fields Validation */
        TransactionValidation.validation(body);

        if(this.userRepository.existsById(body.userId())) {
            User user = this.userRepository.findById(body.userId()).get();

            this.repository.save(
                    new Transaction(
                            body.name(),
                            body.type(),
                            body.method(),
                            user,
                            body.total(),
                            DateEntityMapper.toLocalDate(body.date())
                    )
            );
        } else
            throw new UserNotFound("User not found.", "User not found.");
    }

    public void updateById(UUID id, TransactionPutRequestDTO body) throws InvalidFields, TransactionNotFound {
        if(this.repository.existsById(id)) {
            /* Fields Validation */
            TransactionValidation.validation(body);
            Transaction oldTransaction = this.repository.findById(id).get();
            Transaction updatedTransaction = new Transaction(body.name(), body.type(), body.method(), oldTransaction.getUser(), body.total(), DateEntityMapper.toLocalDate(body.date()));
            updatedTransaction.updateId(id);
            this.repository.save(updatedTransaction);
        } else
            throw new TransactionNotFound("Transaction not found.", "Transaction not found.");
    }

    public void deleteById(UUID id) throws TransactionNotFound {
        if(this.repository.existsById(id))
            this.repository.deleteById(id);
        else
            throw new TransactionNotFound("Transaction not found.", "Transaction not found.");
    }

}
