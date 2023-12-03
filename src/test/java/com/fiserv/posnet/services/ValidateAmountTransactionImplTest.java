package com.fiserv.posnet.services;

import com.fiserv.posnet.service.impl.ValidateAmountTransactionImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(SpringExtension.class)
public class ValidateAmountTransactionImplTest {

    @InjectMocks
    private ValidateAmountTransactionImpl service;

    private Double amountTransaction;
    private Boolean expected;
    private Mono<Boolean> response;

    @Test
    void givenRequestWhenExecuteThenIsOk() {
        givenRequest();
        givenResponse();
        whenExecute();
        thenIsOk();
    }

    private void givenRequest() {
        amountTransaction = 999.00;
    }

    private void givenResponse() {
        expected = Boolean.TRUE;
    }

    private void whenExecute() {
        response = service.execute(amountTransaction);
    }
    private void thenIsOk() {
        StepVerifier.create(response)
                .expectNextMatches(response -> response.equals(expected))
                .expectComplete()
                .verify();
    }
}
