package com.fiserv.posnet.service.impl;

import com.fiserv.posnet.exception.CreditCardNotExistException;
import com.fiserv.posnet.model.dao.CreditCard;
import com.fiserv.posnet.model.dto.response.GetBrandResponse;
import com.fiserv.posnet.model.dto.response.GetCreditCardResponse;
import com.fiserv.posnet.repository.CreditCardRepository;
import com.fiserv.posnet.service.GetInformationCreditCard;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Optional;

@AllArgsConstructor
@Log4j2
@Service
public class GetInformationCreditCardImpl implements GetInformationCreditCard {
    private final CreditCardRepository repository;

    @Override
    public Mono<GetCreditCardResponse> execute(String creditCardNumber) {
        return Mono.just(creditCardNumber)
                .doOnNext(cc -> log.info("request is received: {}", creditCardNumber))
                .map(repository::findByCardNumber)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(creditCard -> {
                    var companyBrand = GetBrandResponse.builder()
                            .name(creditCard.getCreditCardBrand().getName())
                            .build();
                    return GetCreditCardResponse.builder()
                            .cardNumber(creditCard.getCardNumber())
                            .cardHolder(creditCard.getCardHolder())
                            .dateExpiration(creditCard.getDateExpiration().getDayOfMonth() + "/" + creditCard.getDateExpiration().getYear())
                            .brandResponse(companyBrand)
                            .build();
                })
                .switchIfEmpty(Mono.error(CreditCardNotExistException::new))
                .doOnError(error -> log.error("error in GetInformationCreditCardImpl: ",error));

    }
}
