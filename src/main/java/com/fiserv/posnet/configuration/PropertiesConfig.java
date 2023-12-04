package com.fiserv.posnet.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Getter
@Setter
@ConfigurationProperties(prefix = "constants")
public class PropertiesConfig {

    private Map<String, String> mapBrands;
    private Double amountMaximum;
}
