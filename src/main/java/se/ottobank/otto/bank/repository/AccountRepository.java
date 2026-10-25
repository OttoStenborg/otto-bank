package se.ottobank.otto.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import se.ottobank.otto.bank.entity.Account;



public interface AccountRepository extends JpaRepository<Account, Long> {
}
