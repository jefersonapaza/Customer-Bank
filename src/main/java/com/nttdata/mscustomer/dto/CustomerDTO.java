package com.nttdata.mscustomer.dto;

import com.nttdata.mscustomer.model.document.TypeCustomer;
import com.nttdata.mscustomer.model.document.TypeDocument;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CustomerDTO {

    private Long id;
    private String name;
    private String dni;
    private TypeDocument typeDocument;
    private TypeCustomer typeCustomer;
}
