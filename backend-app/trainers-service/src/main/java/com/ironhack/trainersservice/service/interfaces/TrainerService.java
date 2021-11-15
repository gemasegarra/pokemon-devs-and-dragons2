package com.ironhack.trainersservice.service.interfaces;

import com.ironhack.trainersservice.controller.dto.TrainerDTO;
import com.ironhack.trainersservice.model.Trainer;

import java.util.List;

public interface TrainerService {

    TrainerDTO addTrainer(TrainerDTO trainer);
    List<Trainer> showTrainers();
    Trainer getTrainer(Long id);
}
