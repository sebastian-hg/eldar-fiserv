package com.fiserv.posnet.service.impl;

import com.fiserv.posnet.model.dto.request.GetTaxByCreditCardBankRequest;
import com.fiserv.posnet.repository.CreditCardBrandRepository;
import com.fiserv.posnet.service.CalculateRateTax;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.text.DecimalFormat;

@AllArgsConstructor
@Log4j2
public class CalculateRateTaxVisaImpl implements CalculateRateTax {
    private final CreditCardBrandRepository repository;
    @Override
    public Mono<Double> execute(GetTaxByCreditCardBankRequest request) {

        return Mono.just(request.getCalculateDate())
                .map(date -> {
                    var year = String.valueOf(date.getYear()).substring(2,4);
                    return (Double) (Double.parseDouble(year)/date.getMonthValue());
                })
                .doOnNext(tax -> log.info("the rate is obtained {}", tax))
                .doOnError(error -> log.error("error in CalculateRateTaxAmexImpl"));
    }
}
