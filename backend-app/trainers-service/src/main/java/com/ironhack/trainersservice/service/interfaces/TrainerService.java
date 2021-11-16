package com.ironhack.trainersservice.service.interfaces;

import com.ironhack.trainersservice.controller.dto.TrainerInputDTO;
import com.ironhack.trainersservice.controller.dto.TrainerOutputDTO;
import com.ironhack.trainersservice.model.Trainer;

import java.util.List;

public interface TrainerService {

    TrainerOutputDTO addTrainer(TrainerInputDTO trainer);
    List<TrainerOutputDTO> showTrainers();
    TrainerOutputDTO getTrainer(Long id);
}
