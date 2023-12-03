package com.fiserv.posnet.controller;

import com.fiserv.posnet.exception.TaxNotFoundException;
import com.fiserv.posnet.model.dto.request.GetTaxByCreditCardBankRequest;
import com.fiserv.posnet.model.dto.response.RateTaxByBankResponse;
import com.fiserv.posnet.service.GetRateTaxByCreditCardBrand;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@RestController
public class GetTaxByCreditCardBrandController {

    private final GetRateTaxByCreditCardBrand service;

    @GetMapping("/api/v1/tax")
    public Mono<RateTaxByBankResponse> execute(@RequestBody GetTaxByCreditCardBankRequest request) throws TaxNotFoundException, ClassNotFoundException {
        return service.execute(request);
    }
}
