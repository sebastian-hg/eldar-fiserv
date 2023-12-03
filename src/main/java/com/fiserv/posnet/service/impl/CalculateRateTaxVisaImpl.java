package com.fiserv.posnet.service.impl;

import com.fiserv.posnet.model.dto.request.GetTaxByCreditCardBankRequest;
import com.fiserv.posnet.service.CalculateRateTax;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Optional;

@AllArgsConstructor
@Log4j2
@Service
public class CalculateRateTaxVisaImpl implements CalculateRateTax {
    @Override
    public Mono<Double> execute(GetTaxByCreditCardBankRequest request) {
        return Mono.just(request.getCalculateDate())
                .map(date -> {
                    var year = String.valueOf(date.getYear()).substring(2,3);
                    return (Double) (date.getYear()/Double.parseDouble(year));
                });
    }
}
