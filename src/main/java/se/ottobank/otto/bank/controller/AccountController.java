package se.ottobank.otto.bank.controller;

import org.springframework.web.bind.annotation.*;
import se.ottobank.otto.bank.dto.AccountResponse;
import se.ottobank.otto.bank.dto.CreateAccountRequest;
import se.ottobank.otto.bank.service.AccountService;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public AccountResponse createAccount(@RequestBody CreateAccountRequest request) {
        return AccountResponse.from(accountService.openAccount(request.customerId()));
    }
}
