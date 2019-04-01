package com.turchanovskyi.mediasphere.implementation;

import com.turchanovskyi.mediasphere.model.Purchase;
import com.turchanovskyi.mediasphere.repository.PurchaseRepository;
import com.turchanovskyi.mediasphere.service.PurchaseService;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
@Service("purchaseService")
public class PurchaseServiceImpl implements PurchaseService {

    private final PurchaseRepository purchaseRepository;

    public PurchaseServiceImpl(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    @Override
    public Iterable<Purchase> findAll() {
        return purchaseRepository.findAll();
    }

    @Override
    public Purchase findById(Long id) {
        return purchaseRepository.findById(id).get();
    }

    @Override
    public Purchase save(Purchase purchase) {
        return purchaseRepository.save(purchase);
    }

    @Override
    public void deleteById(Long id) {
        purchaseRepository.deleteById(id);
    }
}
