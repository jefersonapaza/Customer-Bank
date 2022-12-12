package com.nttdata.mscustomer.service.external;

import com.nttdata.mscustomer.dto.external.AccountDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import reactor.core.publisher.Mono;

@Log4j2
@Service
public class AccountServiceImpl implements AccountService{


    private final WebClient webClient;

    public AccountServiceImpl(WebClient.Builder webClientBuilder) {
        //microservice gateway (account)
        this.webClient = webClientBuilder.baseUrl("http://ms-gateway:8090").build();
    }

    @CircuitBreaker(name = "service-account", fallbackMethod = "findAllByCodeFallback")
    @TimeLimiter(name = "service-account")
    @Override
    public Flux<AccountDTO> findAllByIdCustomer(String id) {
        return this.webClient.get()
                .uri("/api/account/getAllProductsByCustomer/{id}", id)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError, clientResponse -> Mono.error(new RuntimeException("Error " + clientResponse.statusCode())))
                .onStatus(HttpStatus::is5xxServerError, clientResponse -> Mono.error(new RuntimeException("Error " + clientResponse.statusCode())))
                .bodyToFlux(AccountDTO.class);
    }

    public Flux<AccountDTO> findAllByCodeFallback(Long id, Throwable t) {
        log.info("Fallback method for findAllByCodeFallback (ACCOUNT) executed {}", t.getMessage());
        return Flux.empty();
    }
}
