package com.fiserv.posnet.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CreditCardNotExistException extends Exception{

    private static final String MESSAGE = "Credit Card not Exist in our services";

    public CreditCardNotExistException() {
        super(MESSAGE);
    }
}

