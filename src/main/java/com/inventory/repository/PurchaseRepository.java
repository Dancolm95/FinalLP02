package com.inventory.repository;

import com.inventory.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

    List<Purchase> findBySupplierId(Long supplierId);

    List<Purchase> findByDateBetween(LocalDateTime start, LocalDateTime end);

    List<Purchase> findByUserId(Long userId);

}
