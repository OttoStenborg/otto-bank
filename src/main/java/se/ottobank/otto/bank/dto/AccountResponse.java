package se.ottobank.otto.bank.dto;

import se.ottobank.otto.bank.entity.Account;

import java.math.BigDecimal;

public record AccountResponse(Long id, String accountNumber, BigDecimal balance, Long customerId) {

    public static AccountResponse from(Account account) {
        return new AccountResponse(
                account.getId(),
                account.getAccountNumber(),
                account.getBalance(),
                account.getCustomer().getId()
        );
    }
}