package com.fiserv.posnet.service.impl;

import com.fiserv.posnet.exception.TaxNotFoundException;
import com.fiserv.posnet.model.dto.request.GetTaxByCreditCardBankRequest;
import com.fiserv.posnet.repository.CreditCardBrandRepository;
import com.fiserv.posnet.service.CalculateRateTax;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Optional;

@AllArgsConstructor
@Log4j2
public class CalculateRateTaxNaranjaImpl implements CalculateRateTax {
    private final CreditCardBrandRepository repository;
    @Override
    public Mono<Double> execute(GetTaxByCreditCardBankRequest request) {
        return Mono.just(repository.findByName(request.getCreditCardBrand()))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(tax -> request.getCalculateDate().getDayOfMonth() * tax.getTax())
                .doOnNext(tax -> log.info("the rate is obtained {}", tax))
                .switchIfEmpty(Mono.error(new TaxNotFoundException("tax haven´t been found, please try with other " +
                        "credit card")))
                .doOnError(error -> log.error("error in CalculateRateTaxAmexImpl"));
    }
}
