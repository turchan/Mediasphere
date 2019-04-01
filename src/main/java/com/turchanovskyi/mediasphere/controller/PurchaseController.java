package com.turchanovskyi.mediasphere.controller;

import com.turchanovskyi.mediasphere.model.Purchase;
import com.turchanovskyi.mediasphere.service.PurchaseService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    private final PurchaseService purchaseService;

    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @GetMapping
    public Iterable<Purchase> getAll()
    {
        return purchaseService.findAll();
    }

    @GetMapping("/{purchaseId}")
    public Purchase getMaterial(@PathVariable Long purchaseId)
    {
        return purchaseService.findById(purchaseId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public Purchase create(@RequestBody Purchase purchase)
    {
        purchase.setId_purchase(null);

        purchaseService.save(purchase);

        return purchase;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/update")
    public Purchase update(@RequestBody Purchase purchase)
    {
        purchaseService.save(purchase);

        return purchase;
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete/{purchaseId}")
    public void delete(@PathVariable Long purchaseId)
    {
        purchaseService.deleteById(purchaseId);
    }
}
