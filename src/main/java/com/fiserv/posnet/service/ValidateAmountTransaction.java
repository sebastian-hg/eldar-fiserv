package com.fiserv.posnet.service;

import reactor.core.publisher.Mono;

public interface ValidateAmountTransaction {

    Mono<Boolean> execute (Double amountTransaction);

 }
