package com.batteryshop.repository;

import com.batteryshop.entity.FaultyProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FaultyProductRepository extends JpaRepository<FaultyProductEntity, Integer> {
}
