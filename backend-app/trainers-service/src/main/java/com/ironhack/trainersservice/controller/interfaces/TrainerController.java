package com.ironhack.trainersservice.controller.interfaces;

import com.ironhack.trainersservice.controller.dto.TrainerDTO;
import com.ironhack.trainersservice.model.Trainer;

import java.util.List;


public interface TrainerController {

    TrainerDTO addTrainer(TrainerDTO trainer);
    List<Trainer> showTrainers();
    Trainer getTrainer(Long id);
}
