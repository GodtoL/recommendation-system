package com.matching_system.users.service;

import com.matching_system.users.Models.PurchaseHistory;
import com.matching_system.users.persistence.PurchaseHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class purchaseService{
    private final PurchaseHistoryRepository purchaseHistoryRepository;

    @Autowired
    public purchaseService(PurchaseHistoryRepository purchaseHistoryRepository) {
        this.purchaseHistoryRepository = purchaseHistoryRepository;
    }

    public List<PurchaseHistory> getPurchases(){
        return purchaseHistoryRepository.findAll();
    }


    public List<PurchaseHistory> getPurchaseById(Long userId){
        List<PurchaseHistory> purchases = purchaseHistoryRepository.findAllByUserId(userId);
        if (purchases.isEmpty()){
            throw new RuntimeException("No se encontraron compras con id " + userId);
        }
        return purchases;

    }

    public PurchaseHistory savePurchase(PurchaseHistory purchase){
        return purchaseHistoryRepository.save(purchase);
    }
}
