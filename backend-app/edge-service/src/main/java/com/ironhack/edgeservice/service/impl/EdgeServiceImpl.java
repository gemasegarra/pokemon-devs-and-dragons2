package com.ironhack.edgeservice.service.impl;

import com.ironhack.edgeservice.client.TeamClient;
import com.ironhack.edgeservice.client.TrainersClient;
import com.ironhack.edgeservice.service.interfaces.EdgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EdgeServiceImpl implements EdgeService {

    @Autowired
    private TeamClient teamClient;

    @Autowired
    private TrainersClient trainersClient;


}
