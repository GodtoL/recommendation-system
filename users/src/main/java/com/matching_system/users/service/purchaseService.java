package com.matching_system.users.service;

import com.matching_system.users.Models.PurchaseHistory;
import com.matching_system.users.persistence.PurchaseHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class purchaseService {
    PurchaseHistoryRepository purchaseHistoryRepository;

    @Autowired
    public purchaseService(PurchaseHistoryRepository purchaseHistoryRepository) {
        this.purchaseHistoryRepository = purchaseHistoryRepository;
    }

    public List<PurchaseHistory> getPurchases(){
        return purchaseHistoryRepository.findAll();
    }


    public List<PurchaseHistory> getPurchaseById(Long userId){
        return purchaseHistoryRepository.findAllByUserId(userId);
    }


    public PurchaseHistory postPurchase(PurchaseHistory purchase){
        return purchaseHistoryRepository.save(purchase);
    }
}
