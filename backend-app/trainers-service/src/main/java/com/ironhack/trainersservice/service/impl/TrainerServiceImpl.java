package com.ironhack.trainersservice.service.impl;

import com.ironhack.trainersservice.controller.dto.TrainerInputDTO;
import com.ironhack.trainersservice.controller.dto.TrainerOutputDTO;
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
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TrainerServiceImpl implements TrainerService {

    @Autowired
    private TrainerRepository trainerRepository;

    @Override
    public TrainerOutputDTO addTrainer(TrainerInputDTO trainerDTO) {
        Trainer trainer = new Trainer(trainerDTO.getName(), trainerDTO.getAge(), Hobby.valueOf(trainerDTO.getHobby().toUpperCase()), trainerDTO.getPicture(), new Date());
        trainerRepository.save(trainer);
        return new TrainerOutputDTO(trainer.getId(), trainer.getName(), trainer.getAge(), trainer.getHobby().toString(), trainer.getPicture());
    }

    @Override
    public List<TrainerOutputDTO> showTrainers() {
        List<Trainer> trainerList = trainerRepository.findAll();
        if (trainerList.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There are no trainers in the application at the moment");
        }


        return trainerList.stream()
                .map(trainer -> new TrainerOutputDTO(trainer.getId(), trainer.getName(), trainer.getAge(),
                        trainer.getHobby().toString(), trainer.getPicture()))
                .collect(Collectors.toList());
    }

    @Override
    public TrainerOutputDTO getTrainer(Long id) {
        Optional<Trainer> optionalTrainer = trainerRepository.findById(id);
        if (optionalTrainer.isPresent()) {
            return new TrainerOutputDTO(optionalTrainer.get().getId(), optionalTrainer.get().getName(), optionalTrainer.get().getAge(),
                    optionalTrainer.get().getHobby().toString(), optionalTrainer.get().getPicture());
        } else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Trainer for that id doesn't exists");
    }

}
