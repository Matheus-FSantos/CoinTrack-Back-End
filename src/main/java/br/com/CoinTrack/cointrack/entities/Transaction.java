package br.com.CoinTrack.cointrack.entities;

import br.com.CoinTrack.cointrack.enums.TransactionType;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name="tb_transactions")
public class Transaction implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private UUID id;

    @Column(nullable=false, length=60)
    private String name;

    @Column(nullable=false)
    private Integer type;

    @Column(nullable=false)
    private BigDecimal total;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @Column(nullable=false)
    private LocalDate date;

    public Transaction() { }

    public Transaction(String name, Integer type, User user, BigDecimal total, LocalDate date) {
        this.name = name;
        this.total = total;
        this.user = user;
        this.date = date;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", total=" + total +
                ", date=" + date +
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

    public TransactionType getType() {
        return TransactionType.valueOf(type);
    }

    public void updateType(TransactionType type) {
        if(type != null) {
            this.setType(type);
        }
    }

    public void updateType(Integer type) {
        if(type != null) {
            this.setType(type);
        }
    }

    private void setType(TransactionType type) {
        this.type = type.getCode();
    }

    private void setType(Integer type) {
        this.type = type;
    }

    public User getUser() {
        return user;
    }

    public void updateUser(User user) {
        this.setUser(user);
    }

    private void setUser(User user) {
        this.user = user;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void updateTotal(BigDecimal total) {
        this.setTotal(total);
    }

    private void setTotal(BigDecimal total) {
        this.total = total;
    }

    public LocalDate getDate() {
        return date;
    }

    public void updateDate(LocalDate date) {
        this.setDate(date);
    }

    private void setDate(LocalDate date) {
        this.date = date;
    }

}
