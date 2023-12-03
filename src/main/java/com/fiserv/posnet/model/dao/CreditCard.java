package com.fiserv.posnet.model.dao;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
@Getter
@Setter
@Entity
public class CreditCard {
    @Id
    private Long id;
    @ManyToOne
    @JoinColumn(name = "credit_card_brand_id")
    private CreditCardBrand creditCardBrand;
    private String cardHolder;
    private String cardNumber;
    private LocalDate dateExpiration;


}
