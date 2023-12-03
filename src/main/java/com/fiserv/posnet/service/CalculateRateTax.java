package com.fiserv.posnet.service;

import com.fiserv.posnet.model.dto.request.GetTaxByCreditCardBankRequest;
import reactor.core.publisher.Mono;

public interface CalculateRateTax {
    Mono<Double> execute (GetTaxByCreditCardBankRequest request);
}
