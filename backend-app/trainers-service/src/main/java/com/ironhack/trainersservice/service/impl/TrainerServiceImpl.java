package com.ironhack.trainersservice.service.impl;

import com.ironhack.trainersservice.controller.dto.TrainerDTO;
import com.ironhack.trainersservice.enums.Hobby;
import com.ironhack.trainersservice.model.Trainer;
import com.ironhack.trainersservice.repository.TrainerRepository;
import com.ironhack.trainersservice.service.interfaces.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;

@Service
public class TrainerServiceImpl implements TrainerService {

    @Autowired
    private TrainerRepository trainerRepository;

    @Override
    public TrainerDTO addTrainer(TrainerDTO trainerDTO) {
        Trainer trainer = new Trainer(trainerDTO.getName(), trainerDTO.getAge(), Hobby.valueOf(trainerDTO.getHobby().toUpperCase()), trainerDTO.getPicture(), new Date());
        trainerRepository.save(trainer);
        return trainerDTO;
    }

    @Override
    public List<Trainer> showTrainers() {
        List<Trainer> trainerList = trainerRepository.findAll();

        if (trainerList.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There are no trainers in the application at the moment");
        }
        return trainerRepository.findAll();
    }

    @Override
    public Trainer getTrainer(Long id) {
        return trainerRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Trainer for that id doesn't exists"));
    }
}
