package com.ironhack.edgeservice.controller.impl;

import com.ironhack.edgeservice.controller.dto.PokemonDTO;
import com.ironhack.edgeservice.controller.interfaces.EdgeController;
import com.ironhack.edgeservice.service.interfaces.EdgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EdgeControllerImpl implements EdgeController {


    @Autowired
    private EdgeService edgeService;


    @GetMapping("/pokemons/{name}")
    @ResponseStatus(HttpStatus.OK)
    public List<PokemonDTO> getAll(@PathVariable(name = "name") String name) {
        return edgeService.getAll(name);
    }

    @PostMapping("/pokemons/{name}")
    @ResponseStatus(HttpStatus.CREATED)
    public void store(@PathVariable(name = "name") String name, @RequestBody PokemonDTO pokemonDTO) {
        edgeService.store(name, pokemonDTO);
    }

    @DeleteMapping("/pokemons/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(name = "id") int id) {
        edgeService.delete(id);
    }
}
