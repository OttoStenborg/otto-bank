package se.ottobank.otto.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import se.ottobank.otto.bank.entity.Transaction;


public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
