package com.fiserv.posnet.service;

import com.fiserv.posnet.model.dao.CreditCard;
import com.fiserv.posnet.model.dto.response.GetCreditCardResponse;
import reactor.core.publisher.Mono;

public interface GetInformationCreditCard {
    Mono<GetCreditCardResponse> execute (String creditCardNumber);
}
