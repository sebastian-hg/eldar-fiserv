package com.fiserv.posnet.repository;

import com.fiserv.posnet.model.dao.CreditCard;
import com.fiserv.posnet.model.dao.CreditCardBrandTax;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CreditCardBrandTaxRepository extends JpaRepository<CreditCardBrandTax, Long> {
}
