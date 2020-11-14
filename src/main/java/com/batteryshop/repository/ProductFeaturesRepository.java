package com.batteryshop.repository;

import com.batteryshop.entity.ProductFeaturesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductFeaturesRepository extends JpaRepository<ProductFeaturesEntity, String> {
}
