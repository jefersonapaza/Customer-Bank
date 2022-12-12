package com.nttdata.mscustomer.dto.external;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
public class CreditCardAccountDTO {

    @NotEmpty
    private Long id;

    private String code;
    private String idCustomer;
    private String typeCustomer;
    private String type;
    private Float amount;
}
