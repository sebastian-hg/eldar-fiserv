package com.fiserv.posnet.service.impl;

import com.fiserv.posnet.exception.TaxNotFoundException;
import com.fiserv.posnet.model.dto.request.GetTaxByCreditCardBankRequest;
import com.fiserv.posnet.model.dto.response.RateTaxByBankResponse;
import com.fiserv.posnet.service.GetRateTaxByCreditCardBrand;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.lang.reflect.Type;
import java.util.List;



@Log4j2
@Service
public class GetRateTaxByCreditCardBrandImpl implements GetRateTaxByCreditCardBrand {

    Class<?> instancesBrands = Class.forName("com.fiserv.posnet.service.GetRateTaxByCreditCardBrand");

    public GetRateTaxByCreditCardBrandImpl() throws ClassNotFoundException {

    }


    @Override
    public Mono<RateTaxByBankResponse> execute(GetTaxByCreditCardBankRequest request) throws TaxNotFoundException, ClassNotFoundException {


        return null;

    }
}
