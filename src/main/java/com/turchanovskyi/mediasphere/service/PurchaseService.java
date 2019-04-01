package com.turchanovskyi.mediasphere.service;

import com.turchanovskyi.mediasphere.model.Purchase;

public interface PurchaseService {

    Iterable<Purchase> findAll();
    Purchase findById(Long id);
    Purchase save(Purchase purchase);
    void deleteById(Long id);
}
