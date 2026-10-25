package se.ottobank.otto.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.ottobank.otto.bank.entity.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
