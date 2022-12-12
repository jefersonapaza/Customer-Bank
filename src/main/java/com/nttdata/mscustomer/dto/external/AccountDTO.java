package com.nttdata.mscustomer.dto.external;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class AccountDTO {

    private List<BusinessAccountDTO> businessAccountList;
    private List<CreditCardAccountDTO> creditCardAccountList;
    private List<PersonalAccountDTO> personalAccountList;

    private List<CheckingAccountDTO> checkingAccountList;
    private List<FixedTermAccountDTO> fixedTermAccountList;
    private List<SavingAccountDTO> savingAccountList;

}
