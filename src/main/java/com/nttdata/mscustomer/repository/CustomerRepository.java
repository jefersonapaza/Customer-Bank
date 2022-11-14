package com.nttdata.mscustomer.repository;

import com.nttdata.mscustomer.model.Customer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface CustomerRepository extends ReactiveMongoRepository<Customer,String> {

    Flux<Customer> findByDocumentNumber(String documentNumber);
}
