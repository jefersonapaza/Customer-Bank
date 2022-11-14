package com.nttdata.mscustomer.model;

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

    TypeDocument.EnumDocumentType value;

    public enum EnumDocumentType {
        DNI, RUC
    }
}
