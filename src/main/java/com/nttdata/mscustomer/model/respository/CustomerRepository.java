package com.nttdata.mscustomer.model.respository;

import com.nttdata.mscustomer.model.document.Customer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface CustomerRepository extends ReactiveMongoRepository<Customer,String> {

    Flux<Customer> findByDocumentNumber(String documentNumber);
}
