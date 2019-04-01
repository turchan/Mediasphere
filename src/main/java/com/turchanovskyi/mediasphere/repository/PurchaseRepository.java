package com.turchanovskyi.mediasphere.repository;

import com.turchanovskyi.mediasphere.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
}
