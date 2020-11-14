package com.batteryshop.repository;

import com.batteryshop.entity.ComplaintsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplaintsRepository extends JpaRepository<ComplaintsEntity, Integer> {
}
