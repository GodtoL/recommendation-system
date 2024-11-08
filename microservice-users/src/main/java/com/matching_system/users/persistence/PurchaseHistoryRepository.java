package com.matching_system.users.persistence;

import com.matching_system.users.Models.PurchaseHistory;
import com.matching_system.users.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PurchaseHistoryRepository extends JpaRepository<PurchaseHistory, Long> {
    List<PurchaseHistory> findAllByUserId(Long id);
}
