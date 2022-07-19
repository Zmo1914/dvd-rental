package com.zmo.dbconnect.controllers;

import com.zmo.dbconnect.model.Actor;
import com.zmo.dbconnect.repositories.ActorRepository;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("api/v1/actors")
public record ActorController(ActorService actorService) {

    public void registerActor(@RequestBody ActorRegistrationRequest actorRegistrationRequest){
        log.info("Actor registration {}", actorRegistrationRequest);
        actorService.registerActor(actorRegistrationRequest);
    }
}