package com.ironhack.edgeservice.controller.impl;

import com.ironhack.edgeservice.controller.interfaces.EdgeController;
import com.ironhack.edgeservice.service.interfaces.EdgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EdgeControllerImpl implements EdgeController {


    @Autowired
    private EdgeService edgeService;


}
