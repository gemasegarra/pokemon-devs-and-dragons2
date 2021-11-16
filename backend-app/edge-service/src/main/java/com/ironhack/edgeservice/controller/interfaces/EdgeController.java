package com.ironhack.edgeservice.controller.interfaces;

import com.ironhack.edgeservice.controller.dto.PokemonDTO;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface EdgeController {

    List<PokemonDTO> getAll(String name);
    void store(String name, PokemonDTO pokemonDTO);
    void delete(int id);

}
