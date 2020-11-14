package com.batteryshop.repository;

import com.batteryshop.entity.DealerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DealerRepository extends JpaRepository<DealerEntity, Integer> {
}
