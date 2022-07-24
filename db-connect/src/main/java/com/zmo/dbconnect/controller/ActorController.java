package com.zmo.dbconnect.controller;

import com.zmo.dbconnect.dto.ActorDto;
import com.zmo.dbconnect.repository.ActorRepository;
import com.zmo.dbconnect.service.ActorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(path = "api/v1/actors")
public record ActorController(ActorService actorService) {

    private static ActorRepository actorRepository;

    @PostMapping
    public void registerActor(@RequestBody ActorDto actorDto) {
        log.info("Actor registration {}", actorDto);
        actorService.registerActor(actorDto);
    }

    @DeleteMapping("/{actor_id}")
    public ResponseEntity<Integer> deleteActor(@PathVariable("actor_id") Integer actor_id) {
        boolean isDeleted = actorService.deleteActor(actor_id);
        if (!isDeleted) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }
}