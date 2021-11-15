package com.ironhack.edgeservice.client;

import org.springframework.cloud.openfeign.FeignClient;

//TODO: pendiente de poner nombre del servicio
@FeignClient("team-service")
public interface TeamClient {
}
