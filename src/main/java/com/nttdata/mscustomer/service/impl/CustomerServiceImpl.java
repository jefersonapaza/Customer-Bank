package com.nttdata.mscustomer.service.impl;

import com.nttdata.mscustomer.model.Customer;
import com.nttdata.mscustomer.model.TypeCustomer;
import com.nttdata.mscustomer.repository.CustomerRepository;
import com.nttdata.mscustomer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Mono<Customer> create(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Mono<Customer> update(Customer customer) {
        return customerRepository.findById(customer.getId()).flatMap(c -> {
            return customerRepository.save(customer);
        });
    }

    @Override
    public Mono<Void> delete(String id) {
        return customerRepository.deleteById(id);
    }

    @Override
    public Mono<Customer> findById(String id) {
        return customerRepository.findById(id);
    }
    @Override
    public Flux<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Mono<Customer> findByDocumentNumber(String documentNumber) {
        return customerRepository.findByDocumentNumber(documentNumber).next();
    }
}
