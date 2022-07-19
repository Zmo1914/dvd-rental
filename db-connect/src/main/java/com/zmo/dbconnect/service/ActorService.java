package com.zmo.dbconnect.service;

import com.zmo.dbconnect.controller.ActorRegistrationRequest;
import com.zmo.dbconnect.model.Actor;
import com.zmo.dbconnect.repositories.ActorRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;

@Service
public record ActorService(ActorRepository actorRepository) {
    public void registerActor(ActorRegistrationRequest request) {
        Actor actor = Actor.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .lastUpdate(Timestamp.from(Instant.now()))
                .build();
        //todo: check if firstName and lastName is not taken
        actorRepository.save(actor);
    }
}
