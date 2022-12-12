package com.nttdata.mscustomer.service.external;


import com.nttdata.mscustomer.dto.external.AccountDTO;
import reactor.core.publisher.Flux;

public interface AccountService {

    Flux<AccountDTO> findAllByIdCustomer(String id);
}
