package com.ironhack.edgeservice.service.impl;

import com.ironhack.edgeservice.client.TeamClient;
import com.ironhack.edgeservice.client.TrainersClient;
import com.ironhack.edgeservice.controller.dto.PokemonDTO;
import com.ironhack.edgeservice.service.interfaces.EdgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EdgeServiceImpl implements EdgeService {

    @Autowired
    private TeamClient teamClient;

    @Autowired
    private TrainersClient trainersClient;


    public List<PokemonDTO> getAll(String name) {
        return teamClient.getAll(name);
    }

    public void store(String name, PokemonDTO pokemonDTO) {
        teamClient.store(name, pokemonDTO);
    }

    public void delete(int id) {
        teamClient.delete(id);
    }
}
