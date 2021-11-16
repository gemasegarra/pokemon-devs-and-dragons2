package com.ironhack.trainersservice.controller.interfaces;

import com.ironhack.trainersservice.controller.dto.TrainerInputDTO;
import com.ironhack.trainersservice.controller.dto.TrainerOutputDTO;
import com.ironhack.trainersservice.model.Trainer;

import java.util.List;


public interface TrainerController {

    TrainerOutputDTO addTrainer(TrainerInputDTO trainer);
    List<TrainerOutputDTO> showTrainers();
    TrainerOutputDTO getTrainer(Long id);
}
