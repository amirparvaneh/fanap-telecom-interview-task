package com.fanap.telecom.repository;

import com.fanap.telecom.model.ReSeller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ResellerRepo extends JpaRepository<ReSeller, Long> {
    ReSeller findReSellerByCode(String code);
}
