package com.nttdata.mscustomer.model;

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

    public enum EnumTypeCustomer {
        PERSONAL, EMPRESARIAL
    }
}
