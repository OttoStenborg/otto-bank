package se.ottobank.otto.bank.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
    public AccountResponse createAccount(@RequestBody CreateAccountRequest request){
        Long customerId = request.customerId();
        return AccountResponse.from(accountService.openAccount(customerId));
    }

}
