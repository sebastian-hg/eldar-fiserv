package com.fiserv.posnet.model.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class GetCreditCardResponse {
    @JsonProperty("numero_de_tajeta")
    private String cardNumber;
    @JsonProperty("titular")
    private String cardHolder;
    @JsonProperty("fecha_de_vencimiento")
    private String dateExpiration;
    @JsonProperty("compañia_financiadora")
    private GetBrandResponse brandResponse;

}
