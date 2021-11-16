package com.ironhack.trainersservice.controller.impl;

import com.ironhack.trainersservice.controller.dto.TrainerInputDTO;
import com.ironhack.trainersservice.controller.dto.TrainerOutputDTO;
import com.ironhack.trainersservice.controller.interfaces.TrainerController;
import com.ironhack.trainersservice.model.Trainer;
import com.ironhack.trainersservice.service.impl.TrainerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class TrainerControllerImpl implements TrainerController {

    @Autowired
    private TrainerServiceImpl trainerService;

    @PostMapping("/trainers")
    @ResponseStatus(HttpStatus.CREATED)
    public TrainerOutputDTO addTrainer(@RequestBody @Valid TrainerInputDTO trainer) {
        return trainerService.addTrainer(trainer);
    }

    @Override
    @GetMapping("/trainers")
    @ResponseStatus(HttpStatus.OK)
    public List<TrainerOutputDTO> showTrainers() {
        return trainerService.showTrainers();
    }

    @Override
    @GetMapping("/trainers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TrainerOutputDTO getTrainer(@PathVariable Long id) {
        return trainerService.getTrainer(id);
    }
}