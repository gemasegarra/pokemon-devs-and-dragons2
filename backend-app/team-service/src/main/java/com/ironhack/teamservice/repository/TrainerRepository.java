package com.ironhack.teamservice.repository;

import com.ironhack.teamservice.model.TrainerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainerRepository extends JpaRepository<TrainerEntity, String> {
}
