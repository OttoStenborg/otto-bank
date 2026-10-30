package se.ottobank.otto.bank.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal balance = BigDecimal.ZERO;
    @Column(length = 12, unique = true, nullable = false, updatable = false)
    private String accountNumber;
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer accountHolder;

    public Account(String accountNumber, Customer accountHolder) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
    }

    protected Account() {
    }

    public void withdraw(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Amount must be greater than 0");
        }
        if (amount.compareTo(balance) > 0) {
            throw new IllegalArgumentException("Insufficient funds");
        }
        this.balance = balance.subtract(amount);
    }

    public void deposit(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Amount must be greater than 0");
        }
        this.balance = balance.add(amount);
    }


    //Getters and setters
    public Long getId() {
        return id;
    }


    public BigDecimal getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public Customer getAccountHolder() {
        return accountHolder;
    }
}
