package se.ottobank.otto.bank.service;

import org.springframework.stereotype.Service;
import se.ottobank.otto.bank.entity.Customer;
import se.ottobank.otto.bank.exception.CustomerNotFoundException;
import se.ottobank.otto.bank.repository.CustomerRepository;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer createCustomer(String name) {
        Customer customer = new Customer(name);
        return customerRepository.save(customer);
    }

    public Customer getCustomer(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
    }

    public Customer changeCustomerName(Long id, String newName){
        Customer customer = getCustomer(id);
        customer.changeName(newName);
        return customerRepository.save(customer);
    }

}
