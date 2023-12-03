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
public class CreditCardBrandTax {
    @Id
    private Long id;
    private Double tax;

}
