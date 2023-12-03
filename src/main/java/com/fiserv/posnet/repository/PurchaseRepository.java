package com.fiserv.posnet.repository;

import com.fiserv.posnet.model.dao.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepository  extends JpaRepository<Purchase, Long> {
}
