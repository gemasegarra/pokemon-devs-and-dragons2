package com.ironhack.edgeservice.service.interfaces;

import com.ironhack.edgeservice.controller.dto.PokemonDTO;

import java.util.List;

public interface EdgeService {

    List<PokemonDTO> getAll(String name);
    void store(String name, PokemonDTO pokemonDTO);
    void delete(int id);

}
