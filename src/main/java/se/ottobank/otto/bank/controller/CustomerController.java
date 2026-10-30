package se.ottobank.otto.bank.controller;

import org.springframework.web.bind.annotation.*;
import se.ottobank.otto.bank.dto.ChangeCustomerNameRequest;
import se.ottobank.otto.bank.dto.CreateCustomerRequest;
import se.ottobank.otto.bank.dto.CustomerResponse;
import se.ottobank.otto.bank.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public CustomerResponse createCustomer(@RequestBody CreateCustomerRequest request) {
        return CustomerResponse.from(customerService.createCustomer(request.name()));
    }




}
