package com.fiserv.posnet.service.impl;

import com.fiserv.posnet.service.ValidateAmountTransaction;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.lang.reflect.Type;
import java.util.Arrays;

@AllArgsConstructor
@Log4j2
@Service
public class ValidateAmountTransactionImpl implements ValidateAmountTransaction {
    @Override
    public Mono<Boolean> execute(Double amountTransaction) {
        return Mono.just(amountTransaction)
                .map(aDouble -> aDouble < 1000.00)
                .map(Boolean.TRUE::equals)
                .flatMap( Mono::just)
                .defaultIfEmpty(Boolean.FALSE);
    }
}
