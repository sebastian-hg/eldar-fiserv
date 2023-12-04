package com.fiserv.posnet.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Credit Card not Exist in our services")

public class CreditCardBrandNotFoundException extends Exception{

    private static final String MESSAGE = "Credit Card not Exist in our services ";

    public CreditCardBrandNotFoundException() {
        super(MESSAGE);
    }
    public CreditCardBrandNotFoundException(String messageError) {
        super(messageError);
    }
}

