package com.ironhack.trainersservice.controller.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.trainersservice.controller.dto.TrainerDTO;
import com.ironhack.trainersservice.enums.Hobby;
import com.ironhack.trainersservice.model.Trainer;
import com.ironhack.trainersservice.repository.TrainerRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.StandardCharsets;


import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class TrainerControllerImplTest {


    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private TrainerRepository trainerRepository;


    private MockMvc mockMvc;
    private final ObjectMapper objectMapper = new ObjectMapper();
    private Trainer trainer;
    private Trainer trainer2;
    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .build();

        trainer = new Trainer();
        trainer.setName("Prueba");
        trainer.setAge((byte) 33);
        trainer.setHobby(Hobby.BLACKBELT);
        trainer.setPicture("");
        trainerRepository.save(trainer);

        trainer2 = new Trainer();
        trainer2.setName("Prueba2");
        trainer2.setAge((byte) 66);
        trainer2.setHobby(Hobby.POKEMANIAC);
        trainer2.setPicture("");
        trainerRepository.save(trainer2);
    }

    @AfterEach
    void tearDown() {
        trainerRepository.deleteAll();
    }

    @Test
    void addTrainer_BodyKO() throws Exception {


        TrainerDTO trainerDTO = new TrainerDTO();
        trainerDTO.setHobby("Blackbelt");
        trainerDTO.setPicture("");

        String body = objectMapper.writeValueAsString(trainerDTO);


        MvcResult mvcResult = mockMvc.perform(post("/trainers")
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                )
              .andExpect(status().isBadRequest())
                .andReturn();


    }
    @Test
    void addTrainer_BodyOK() throws Exception {


        TrainerDTO trainerDTO = new TrainerDTO();
        trainerDTO.setName("Prueba3");
        trainerDTO.setAge((byte) 33);
        trainerDTO.setHobby("Blackbelt");
        trainerDTO.setPicture("");

        String body = objectMapper.writeValueAsString(trainerDTO);


        MvcResult mvcResult = mockMvc.perform(post("/trainers")
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                )
                .andExpect(status().isCreated())
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8).contains("Prueba3"));

    }

    @Test
    void showTrainers_NoTrainerInDataBase() throws Exception {

        trainerRepository.deleteAll();
        MvcResult mvcResult = mockMvc.perform(get("/trainers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                )
                .andExpect(status().isNotFound())
                .andReturn();
    }

    @Test
    void showTrainers_OK() throws Exception {

        MvcResult mvcResult = mockMvc.perform(get("/trainers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                )
                .andExpect(status().isOk())
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8).contains("Prueba"));
        assertTrue(mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8).contains("Prueba2"));

    }



    @Test
    void getTrainer_TrainerDoesNotExist() throws Exception {

        mockMvc.perform(get("/trainers/Noexiste")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                )
                .andExpect(status().isNotFound());
    }

    @Test
    void getTrainer_OK_TrainerExist() throws Exception {

        MvcResult mvcResult = mockMvc.perform(get("/trainers/Prueba")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                )
                .andExpect(status().isOk())
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8).contains("Prueba"));
        assertTrue(mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8).contains("BLACKBELT"));

    }


    @Test
    void deleteTrainer_TrainerNotExistsInDataBase() throws Exception {

            mockMvc.perform(delete("/trainers/Paco")
                            .contentType(MediaType.APPLICATION_JSON)
                    )
                    .andExpect(status().isNotFound());
    }

    @Test
    void deleteTrainer_TrainerExistsInDataBase() throws Exception {

        mockMvc.perform(delete("/trainers/"+ trainer.getName())
                        .contentType(MediaType.APPLICATION_JSON)
                )                .andExpect(status().isNoContent());
    }


}







