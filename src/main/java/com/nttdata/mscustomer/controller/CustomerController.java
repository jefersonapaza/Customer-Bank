package com.nttdata.mscustomer.controller;

import com.nttdata.mscustomer.dto.external.AccountDTO;
import com.nttdata.mscustomer.model.document.Customer;
import com.nttdata.mscustomer.model.service.CustomerService;
import com.nttdata.mscustomer.service.external.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private AccountService accountService;

    @PostMapping("/insert")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Customer> createCustomer(@RequestBody Customer customer) {
        return customerService.create(customer);
    }

    @PutMapping("/update")
    public Mono<ResponseEntity<Customer>> updateClient(@RequestBody Customer customer) {
        return customerService.update(customer)
                .map(c -> new ResponseEntity<>(c, HttpStatus.ACCEPTED))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/delete/{id}")
    public Mono<Void> deleteByIdClient(@PathVariable String id) {
        return customerService.delete(id);
    }

    @GetMapping("/find/{id}")
    @ResponseBody
    public Mono<Customer> getClientById(@PathVariable String id) {
        return customerService.findById(id);
    }

    @GetMapping("/list")
    public Flux<Customer> list(){
        return customerService.findAll();
    }

    @GetMapping("/document/{number}")
    public Mono<Customer> findNumber(@PathVariable String number){
        return customerService.findByDocumentNumber(number);
    }

    @GetMapping("/getAllProductsByCustomer/{id_customer}")
    public Flux<ResponseEntity<AccountDTO>> getAllProductsByCustomer(@PathVariable String id_customer){
        return accountService.findAllByIdCustomer(id_customer).map(aldto -> new  ResponseEntity<>(aldto , HttpStatus.ACCEPTED));
    }


}
