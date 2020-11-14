package com.batteryshop.repository;

import com.batteryshop.entity.ReplacementProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReplacementProductRepository extends JpaRepository<ReplacementProductEntity, Integer> {
}
