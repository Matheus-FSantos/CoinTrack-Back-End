package br.com.CoinTrack.cointrack.entities;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name="tb_users")
public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID id;

    @Column(nullable=false, length=60)
    private String name;

    @Column(nullable=false, length=120, unique=true)
    private String email;

    @Column(nullable=false, length=40)
    private String password;

    public User() { }

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public UUID getId() {
        return id;
    }

    public void updateId(UUID id) {
        this.setId(id);
    }

    private void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void updateName(String name) {
        this.setName(name);
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void updateEmail(String email) {
        this.setEmail(email);
    }

    private void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void updatePassword(String password) {
        this.setPassword(password);
    }

    private void setPassword(String password) {
        this.password = password;
    }
}
