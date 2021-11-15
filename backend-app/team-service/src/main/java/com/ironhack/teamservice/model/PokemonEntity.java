package com.ironhack.teamservice.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "pokemon")
public class PokemonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "trainer_name")
    private TrainerEntity trainer;

    @OneToMany(mappedBy = "pokemon")
    private List<PokemonTypeEntity> pokemonTypeList;

    @OneToMany(mappedBy = "pokemon")
    private List<PokemonStatsEntity> pokemonStatsList;

    private LocalDate creationDate;
    private LocalDate modificationDate;
    private String userCreation;
    private String userModification;

    public PokemonEntity() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDate getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(LocalDate modificationDate) {
        this.modificationDate = modificationDate;
    }

    public String getUserCreation() {
        return userCreation;
    }

    public void setUserCreation(String userCreation) {
        this.userCreation = userCreation;
    }

    public String getUserModification() {
        return userModification;
    }

    public void setUserModification(String userModification) {
        this.userModification = userModification;
    }

    public TrainerEntity getTrainer() {
        return trainer;
    }

    public void setTrainer(TrainerEntity trainer) {
        this.trainer = trainer;
    }

    public List<PokemonTypeEntity> getPokemonTypeList() {
        return pokemonTypeList;
    }

    public void setPokemonTypeList(List<PokemonTypeEntity> pokemonTypeList) {
        this.pokemonTypeList = pokemonTypeList;
    }

    public List<PokemonStatsEntity> getPokemonStatsList() {
        return pokemonStatsList;
    }

    public void setPokemonStatsList(List<PokemonStatsEntity> pokemonStatsList) {
        this.pokemonStatsList = pokemonStatsList;
    }
}
