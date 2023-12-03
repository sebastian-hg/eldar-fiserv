package com.fiserv.posnet.service;

import reactor.core.publisher.Mono;

public interface ValidateExpirationDate {
    Mono<Boolean> execute (String expirationDate);
}
