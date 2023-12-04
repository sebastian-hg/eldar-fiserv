package com.fiserv.posnet.model.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import reactor.core.publisher.Mono;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class RateTaxByBankResponse {
    @JsonProperty("enridad_financiera")
    private String bank;
    @JsonProperty("porcentaje_de_tasa")
    private String rateTaxPercent;
    @JsonProperty("total_intereses")
    private String totalTaxes;
    @JsonProperty("total_con_intereses")
    private String totalToPay;
}
