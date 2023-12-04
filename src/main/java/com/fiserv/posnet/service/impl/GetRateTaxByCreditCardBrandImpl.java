package com.fiserv.posnet.service.impl;

import com.fiserv.posnet.configuration.PropertiesConfig;
import com.fiserv.posnet.exception.AmountInvalidException;
import com.fiserv.posnet.exception.CreditCardBrandNotFoundException;
import com.fiserv.posnet.exception.TaxNotFoundException;
import com.fiserv.posnet.model.dto.request.GetTaxByCreditCardBankRequest;
import com.fiserv.posnet.model.dto.response.RateTaxByBankResponse;
import com.fiserv.posnet.repository.CreditCardBrandRepository;
import com.fiserv.posnet.service.CalculateRateTax;
import com.fiserv.posnet.service.GetRateTaxByCreditCardBrand;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@Log4j2
@Service
public class GetRateTaxByCreditCardBrandImpl implements GetRateTaxByCreditCardBrand {


    private final PropertiesConfig mapperConfig;
    private final CreditCardBrandRepository creditCardBrandRepository;
    private final Map<String, CalculateRateTax> companiesMap;
    private final ValidateAmountTransactionImpl validateAmountTransaction;


    public GetRateTaxByCreditCardBrandImpl(PropertiesConfig mapperConfig, CreditCardBrandRepository creditCardBrandRepository, ValidateAmountTransactionImpl validateAmountTransaction) {
        this.mapperConfig = mapperConfig;
        this.creditCardBrandRepository = creditCardBrandRepository;
        this.validateAmountTransaction = validateAmountTransaction;
        this.companiesMap = new HashMap<>();
    }

    @PostConstruct
    private void init() {
        mapperConfig.getMapBrands().forEach((String k, String className) -> {
            try {
                //obtiene la clase correspondiente
                Class<?> objetcClass = Class.forName(className);
                //genera el contructor
                Constructor<?> constructor = objetcClass.getDeclaredConstructor(CreditCardBrandRepository.class);
                // Crear una instancia de la clase y le pasa el contructor
                CalculateRateTax instance = (CalculateRateTax) constructor.newInstance(creditCardBrandRepository);
                companiesMap.put(k, instance);
            } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException |
                     InstantiationException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        });
    }

    BigDecimal totalTax = BigDecimal.ZERO;

    @Override
    public Mono<RateTaxByBankResponse> execute(GetTaxByCreditCardBankRequest request) throws TaxNotFoundException, ClassNotFoundException {
        return Mono.just(Optional.ofNullable(companiesMap.get(request.getCreditCardBrand())))
                .doOnNext(op -> log.info("request is received: {}", request))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .switchIfEmpty(Mono.error(new CreditCardBrandNotFoundException()))
                .doOnError(error -> log.error("error in GetRateTaxByCreditCardBrandImpl: ", error))
                .map(calculateRateTax -> calculateRateTax.execute(request))
                .flatMap(tax -> tax)
                .zipWith(validateAmountTransaction.execute(request.getAmountTransaction()))
                .filter(tuple2 -> Boolean.TRUE.equals(tuple2.getT2()))
                .switchIfEmpty(Mono.error(new AmountInvalidException()))
                .doOnError(error -> log.error("error in GetRateTaxByCreditCardBrandImpl: ", error))
                .map(tuple2 -> {
                    totalTax = BigDecimal.valueOf(request.getAmountTransaction())
                            .divide(BigDecimal.valueOf(100.00)).setScale(2, RoundingMode.HALF_UP)
                            .multiply(BigDecimal.valueOf(tuple2.getT1())).setScale(2, RoundingMode.HALF_UP);
                    return RateTaxByBankResponse.builder()
                            .bank(request.getCreditCardBrand())
                            .rateTaxPercent(BigDecimal.valueOf(tuple2.getT1()).setScale(2, RoundingMode.HALF_UP) + "%")
                            .totalTaxes(String.valueOf(totalTax + "ARS"))
                            .totalToPay(BigDecimal.valueOf(request.getAmountTransaction()).add(totalTax).toString())
                            .build();
                });
    }
}
