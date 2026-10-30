package se.ottobank.otto.bank.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.ottobank.otto.bank.dto.AccountResponse;
import se.ottobank.otto.bank.service.AccountService;

@RestController
@PreAuthorize("hasRole('ADMIN')")
@RequestMapping("/api/admin/accounts")
public class AdminAccountController {
    private final AccountService accountService;

    public AdminAccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/{id}")
    public AccountResponse getAccount(@PathVariable Long id) {
        return AccountResponse.from(accountService.getAccount(id));
    }
}
