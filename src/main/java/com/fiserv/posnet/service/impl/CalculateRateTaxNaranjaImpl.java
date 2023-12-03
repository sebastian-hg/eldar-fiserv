package com.fiserv.posnet.service.impl;

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
@Service
public class CalculateRateTaxNaranjaImpl implements CalculateRateTax {
    private final CreditCardBrandRepository repository;
    @Override
    public Mono<Double> execute(GetTaxByCreditCardBankRequest request) {
        return Mono.just(repository.findByName(request.getCreditCardBrand()))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(tax -> request.getCalculateDate().getDayOfMonth() * tax.getTax());
    }
}
