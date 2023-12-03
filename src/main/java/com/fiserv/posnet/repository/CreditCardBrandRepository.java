package com.fiserv.posnet.repository;

import com.fiserv.posnet.model.dao.CreditCard;
import com.fiserv.posnet.model.dao.CreditCardBrand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CreditCardBrandRepository  extends JpaRepository<CreditCardBrand, Long> {
    Optional<CreditCardBrand> findByName(String nameBrand);

}
