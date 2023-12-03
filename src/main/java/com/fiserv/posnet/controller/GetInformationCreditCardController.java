package com.fiserv.posnet.controller;

import com.fiserv.posnet.model.dto.response.GetCreditCardResponse;
import com.fiserv.posnet.service.GetInformationCreditCard;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;


@AllArgsConstructor
@RestController
public class GetInformationCreditCardController {
    private GetInformationCreditCard service;

    @GetMapping("/api/v1/informacion-tarjeta")
    public Mono<GetCreditCardResponse> execute(@RequestParam(name = "number", required = true) String creditCardNumber) {
        return service.execute(creditCardNumber);
    }
}
