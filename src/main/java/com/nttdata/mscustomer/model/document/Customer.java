package com.nttdata.mscustomer.model.document;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@Document(collection = "customer")
public class Customer {

    @Id
    String id;

    @NotEmpty
    String firstName;

    @NotEmpty
    String lastName;

    @NotNull
    String documentNumber;

    @Valid
    TypeDocument typeDocument;

    @Valid
    TypeCustomer typeCustomer;

}