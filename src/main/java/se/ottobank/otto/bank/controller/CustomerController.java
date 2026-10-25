package se.ottobank.otto.bank.controller;

import org.springframework.web.bind.annotation.*;
import se.ottobank.otto.bank.dto.CreateCustomerRequest;
import se.ottobank.otto.bank.entity.Customer;
import se.ottobank.otto.bank.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @PostMapping
    public Customer createCustomer(@RequestBody CreateCustomerRequest request){
        return customerService.createCustomer(request.name());
    }

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable Long id){
        return customerService.getCustomer(id);
    }


}
