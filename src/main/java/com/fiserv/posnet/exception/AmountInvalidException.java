package com.fiserv.posnet.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class AmountInvalidException extends Exception{

    private static final String MESSAGE = "The amount consulted is greater than the allowed amount of 1000 pesos ";

    public AmountInvalidException() {
        super(MESSAGE);
    }
    public AmountInvalidException(String messageError) {
        super(MESSAGE + messageError);
    }
}

