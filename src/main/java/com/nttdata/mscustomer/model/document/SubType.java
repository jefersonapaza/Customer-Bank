package com.nttdata.mscustomer.model.document;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class SubType {

    @Id
    String id;

    EnumSubType value;

    public enum EnumSubType {
        VIP, PYME
    }
}
