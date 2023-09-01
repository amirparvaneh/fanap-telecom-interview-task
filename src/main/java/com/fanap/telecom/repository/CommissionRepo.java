package com.fanap.telecom.repository;

import com.fanap.telecom.model.Commission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommissionRepo extends JpaRepository<Commission,Long> {
}
