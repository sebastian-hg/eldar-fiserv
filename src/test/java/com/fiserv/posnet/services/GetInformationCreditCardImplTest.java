package com.fiserv.posnet.services;

import com.fiserv.posnet.model.dao.CreditCard;
import com.fiserv.posnet.model.dao.CreditCardBrand;
import com.fiserv.posnet.model.dto.response.GetBrandResponse;
import com.fiserv.posnet.model.dto.response.GetCreditCardResponse;
import com.fiserv.posnet.repository.CreditCardRepository;
import com.fiserv.posnet.service.impl.GetInformationCreditCardImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(SpringExtension.class)
public class GetInformationCreditCardImplTest {

    @Mock
    private CreditCardRepository repository;

    @InjectMocks
    private GetInformationCreditCardImpl service;

    private String creditCardRequest;
    private GetCreditCardResponse creditCartExpected;
    private Mono<GetCreditCardResponse> creditCardResponse;
    private GetBrandResponse getBrandResponse;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Test
    void givenRequestWhenExecuteThenIsOk() {
        givenRequest();
        givenRepository();
        givenResponse();
        whenExecute();
        thenIsOk();
    }

    private void givenRequest() {
        creditCardRequest = "1221122112121212";
    }

    private void givenRepository() {

        var brand = CreditCardBrand.builder()
                .id(1L)
                .name("Visa")
                .build();
        var creditCard = CreditCard.builder()
                .id(1L)
                .cardNumber("1212121212121212")
                .dateExpiration(LocalDate.parse("01/11/2032",formatter))
                .creditCardBrand(brand)
                .cardHolder("Sebastian Hernandez")
                .build();
        Mockito.when(repository.findByCardNumber(any(String.class))).thenReturn(Optional.of(creditCard));
    }

    private void givenResponse() {
        getBrandResponse = GetBrandResponse.builder()
                .name("Visa")
                .build();

        creditCartExpected = GetCreditCardResponse.builder()
                .cardNumber("1212121212121212")
                .cardHolder("Sebastian Hernandez")
                .brandResponse(getBrandResponse)
                .dateExpiration("1/2032")
                .build();

    }

    private void whenExecute() {
        creditCardResponse = service.execute(creditCardRequest);
    }

    private void thenIsOk() {
        StepVerifier.create(creditCardResponse)
                .expectNextMatches(creditCard -> creditCard.equals(creditCartExpected))
                .expectComplete()
                .verify();
        Mockito.verify(repository).findByCardNumber(any(String.class));
    }
}
