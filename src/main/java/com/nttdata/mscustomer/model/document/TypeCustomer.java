package com.nttdata.mscustomer.model.document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@AllArgsConstructor
public class TypeCustomer {

    @Id
    String id;

    EnumTypeCustomer value;

    SubType subType;

    public enum EnumTypeCustomer {
        PERSONAL, BUSINESS
    }
}
