package com.fiserv.posnet.model.dao;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
@Getter
@Setter
@Entity
public class Purchase {
    @Id
    private Long id;
    @ManyToOne
    @JoinColumn(name = "credit_card_id")
    private CreditCard creditCard;
    private Double totalAmount;
    private String currency;
    private String  descriptionOperation;

}
