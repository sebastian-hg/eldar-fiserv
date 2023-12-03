package com.fiserv.posnet.controller;

import com.fiserv.posnet.model.dao.CreditCard;
import com.fiserv.posnet.service.GetInformationCreditCard;
import com.fiserv.posnet.service.ValidateExpirationDate;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;


@AllArgsConstructor
@RestController
public class ValidateExpirationDateController {
    private ValidateExpirationDate service;

    @GetMapping("/api/v1/validar-fecha-vencimiento")
    public Mono<Boolean> execute(@RequestParam(name = "date", required = true) String request) {
        return service.execute(request);
    }
}
