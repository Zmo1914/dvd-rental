package com.zmo.dbconnect.controllers;

import com.zmo.dbconnect.model.Actor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;

@Service
public class ActorService {
    public void registerActor(ActorRegistrationRequest request) {
        Actor actor = Actor.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .lastUpdate(Timestamp.from(Instant.now()))
                .build();
        //todo: check if firstName and lastName is not taken
        //todo: store actor in db
    }
}
