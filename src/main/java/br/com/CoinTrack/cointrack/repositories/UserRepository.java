package br.com.CoinTrack.cointrack.repositories;

import br.com.CoinTrack.cointrack.entities.Transaction;
import br.com.CoinTrack.cointrack.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    public boolean existsByEmail(String email);
    public Optional<User> findByEmail(String email);
}
