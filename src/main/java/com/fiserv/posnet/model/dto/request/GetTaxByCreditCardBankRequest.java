package com.fiserv.posnet.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetTaxByCreditCardBankRequest {
    private String creditCardBrand;
    private Double amountTransaction;
    private LocalDate calculateDate;

}
