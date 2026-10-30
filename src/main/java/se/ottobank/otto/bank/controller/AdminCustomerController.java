package se.ottobank.otto.bank.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import se.ottobank.otto.bank.dto.ChangeCustomerNameRequest;
import se.ottobank.otto.bank.dto.CustomerResponse;
import se.ottobank.otto.bank.service.CustomerService;

@RestController
@PreAuthorize("hasRole('ADMIN')")
@RequestMapping("/api/admin/customers")
public class AdminCustomerController {
    private final CustomerService customerService;

    public AdminCustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{id}")
    public CustomerResponse getCustomer(@PathVariable Long id) {
        return CustomerResponse.from(customerService.getCustomer(id));
    }

    @PatchMapping("/{id}")
    public CustomerResponse changeCustomerName(@RequestBody ChangeCustomerNameRequest request, @PathVariable Long id) {
        return CustomerResponse.from(customerService.changeCustomerName(id, request.newName()));
    }
}
