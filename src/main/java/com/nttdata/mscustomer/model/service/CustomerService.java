package com.nttdata.mscustomer.model.service;

import com.nttdata.mscustomer.model.document.Customer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerService {

    Mono<Customer> create(Customer customer);

    Mono<Customer> update(Customer customer);

    Mono<Void> delete(String id);

    Mono<Customer> findById(String id);

    Flux<Customer> findAll();

    Mono<Customer> findByDocumentNumber(String documentNumber);

}
