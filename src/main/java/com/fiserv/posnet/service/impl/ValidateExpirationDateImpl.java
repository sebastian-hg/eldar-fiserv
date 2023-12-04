package com.fiserv.posnet.service.impl;

import com.fiserv.posnet.service.ValidateExpirationDate;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Log4j2
@Service
public class ValidateExpirationDateImpl implements ValidateExpirationDate {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Override
    public Mono<Boolean> execute(String expirationDate) {

        return Mono.just(expirationDate)
                .doOnNext(a -> log.info("request is received: {}", expirationDate))
                .map(date -> {
                    return LocalDate.parse("01/" + date, formatter);
                })
                .map(localDateCreditCard -> {
                    LocalDate localDateNow = LocalDate.now();
                    return localDateNow.isBefore(localDateCreditCard);
                });
    }
}
