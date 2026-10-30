package se.ottobank.otto.bank.dto;

import se.ottobank.otto.bank.entity.Customer;

public record CustomerResponse(Long id, String name) {
    public static CustomerResponse from(Customer customer) {
        return new CustomerResponse(
                customer.getId(),
                customer.getName()
        );
    }
}
