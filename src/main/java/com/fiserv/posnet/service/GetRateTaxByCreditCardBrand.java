package com.fiserv.posnet.service;

import com.fiserv.posnet.exception.TaxNotFoundException;
import com.fiserv.posnet.model.dto.request.GetTaxByCreditCardBankRequest;
import com.fiserv.posnet.model.dto.response.RateTaxByBankResponse;
import reactor.core.publisher.Mono;

public interface GetRateTaxByCreditCardBrand {
    Mono<RateTaxByBankResponse> execute(GetTaxByCreditCardBankRequest request) throws TaxNotFoundException, ClassNotFoundException;

}
