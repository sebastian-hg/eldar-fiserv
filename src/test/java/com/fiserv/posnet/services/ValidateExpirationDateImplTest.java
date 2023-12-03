package com.fiserv.posnet.services;

import com.fiserv.posnet.service.impl.ValidateAmountTransactionImpl;
import com.fiserv.posnet.service.impl.ValidateExpirationDateImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@ExtendWith(SpringExtension.class)
public class ValidateExpirationDateImplTest {

    @InjectMocks
    private ValidateExpirationDateImpl service;

    private String stringDate;
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
        stringDate = "11/2032";
    }

    private void givenResponse() {
        expected = Boolean.TRUE;
    }

    private void whenExecute() {
        response = service.execute(stringDate);
    }
    private void thenIsOk() {
        StepVerifier.create(response)
                .expectNextMatches(response -> response.equals(expected))
                .expectComplete()
                .verify();
    }
}
