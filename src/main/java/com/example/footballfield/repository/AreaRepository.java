package com.example.footballfield.repository;

import com.example.footballfield.entity.Area;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AreaRepository extends JpaRepository<Area, String> {
    Optional<Area> findByIdAndUserId(String id,String userId);
}
