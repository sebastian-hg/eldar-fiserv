package com.fiserv.posnet.model.dao;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
@Getter
@Setter
@Entity
public class CreditCardBrand {
    @Id
    private Long id;
    private String name;
    private LocalDate dateModified;
    private Double tax;
}
