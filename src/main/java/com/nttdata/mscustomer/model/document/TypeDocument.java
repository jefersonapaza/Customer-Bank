package com.nttdata.mscustomer.model.document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@AllArgsConstructor
public class TypeDocument {

    @Id
    String id;

    EnumTypeDocument value;

    public enum EnumTypeDocument {
        DNI, RUC, CE
    }
}
