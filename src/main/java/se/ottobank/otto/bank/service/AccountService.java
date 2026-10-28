package se.ottobank.otto.bank.service;

import org.springframework.stereotype.Service;
import se.ottobank.otto.bank.entity.Account;
import se.ottobank.otto.bank.entity.Customer;
import se.ottobank.otto.bank.exception.AccountNotFoundException;
import se.ottobank.otto.bank.repository.AccountRepository;

import java.math.BigDecimal;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class AccountService {
    private final AccountRepository accountRepository;
    private final CustomerService customerService;

    public AccountService(AccountRepository accountRepository, CustomerService customerService) {
        this.accountRepository = accountRepository;
        this.customerService = customerService;
    }
    private String generateAccountNumber() {
        String accountNumber;
        do {
            int number = ThreadLocalRandom.current().nextInt(10_000_000);
            accountNumber = String.format("9999-%07d", number);
        } while (accountRepository.existsByAccountNumber(accountNumber));
        return accountNumber;
    }


    public Account openAccount(Long customerId){
        Customer customer = customerService.getCustomer(customerId);
        String accountNumber = generateAccountNumber();
        Account account = new Account(accountNumber,customer);
        return accountRepository.save(account);

    }

    public Account getAccount(Long id){
        return accountRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException(id));
    }

    public void deposit(Long id, BigDecimal amount){

    }
}
