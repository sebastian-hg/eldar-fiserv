package com.fiserv.posnet.controller;

import com.fiserv.posnet.service.ValidateAmountTransaction;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;


@AllArgsConstructor
@RestController
public class ValidateAmountTransactionController {

    private ValidateAmountTransaction service;
    @GetMapping("/api/v1/validate-amount")
    public Mono<Boolean> execute(@RequestParam(name = "amount", required = true) Double request){
        return service.execute(request);
    }
}
