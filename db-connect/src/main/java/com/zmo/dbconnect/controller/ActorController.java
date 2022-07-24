package com.zmo.dbconnect.controller;

import com.zmo.dbconnect.dto.ActorDto;
import com.zmo.dbconnect.service.ActorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/v1/actors")
public record ActorController(ActorService actorService) {

    @PostMapping
    public void registerActor(@RequestBody ActorDto actorDto){
        log.info("Actor registration {}", actorDto);
        actorService.registerActor(actorDto);
    }
}