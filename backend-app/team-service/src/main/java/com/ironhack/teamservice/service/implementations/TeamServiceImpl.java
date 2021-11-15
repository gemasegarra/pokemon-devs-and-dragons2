package com.ironhack.teamservice.service.implementations;

import com.ironhack.teamservice.controller.dto.PokemonDTO;
import com.ironhack.teamservice.controller.dto.PokemonStatsDTO;
import com.ironhack.teamservice.model.PokemonEntity;
import com.ironhack.teamservice.model.PokemonStatsEntity;
import com.ironhack.teamservice.model.PokemonTypeEntity;
import com.ironhack.teamservice.model.TrainerEntity;
import com.ironhack.teamservice.repository.PokemonRepository;
import com.ironhack.teamservice.repository.PokemonStatsRepository;
import com.ironhack.teamservice.repository.PokemonTypeRepository;
import com.ironhack.teamservice.repository.TrainerRepository;
import com.ironhack.teamservice.service.interfaces.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TrainerRepository trainerRepository;

    @Autowired
    private PokemonRepository pokemonRepository;

    @Autowired
    private PokemonTypeRepository pokemonTypeRepository;

    @Autowired
    private PokemonStatsRepository pokemonStatsRepository;

    @Override
    public List<PokemonDTO> getAll(String name) {

        Optional<TrainerEntity> optionalTrainer = trainerRepository.findById(name);

        if (!optionalTrainer.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There are not trainer with that name");
        }

        List<PokemonEntity> pokemonList = optionalTrainer.get().getPokemonList();
        List<PokemonDTO> outputPokemonList = new ArrayList<>();

        for (PokemonEntity pokemon : pokemonList) {
            PokemonDTO pokemonDTO = new PokemonDTO();
            pokemonDTO.setId(pokemon.getId());
            pokemonDTO.setName(pokemon.getName());
            pokemonDTO.setImageUrl(pokemon.getImageUrl());

            List<String> typeList = new ArrayList<>();
            for (PokemonTypeEntity pokemonType : pokemon.getPokemonTypeList()) {
                typeList.add(pokemonType.getName());
            }
            pokemonDTO.setTypeList(typeList);

            List<PokemonStatsDTO> statsDTOList = new ArrayList<>();
            for (PokemonStatsEntity pokemonStats : pokemon.getPokemonStatsList()) {
                PokemonStatsDTO pokemonStatsDTO = new PokemonStatsDTO();
                pokemonStatsDTO.setName(pokemonStats.getName());
                pokemonStatsDTO.setValue(pokemonStats.getValue());
                statsDTOList.add(pokemonStatsDTO);
            }
            pokemonDTO.setStatsList(statsDTOList);

            outputPokemonList.add(pokemonDTO);
        }

        return outputPokemonList;
    }

    @Override
    public void store(String name, PokemonDTO pokemonDTO) {

    }

    @Override
    public void delete(int id) {

    }
}
