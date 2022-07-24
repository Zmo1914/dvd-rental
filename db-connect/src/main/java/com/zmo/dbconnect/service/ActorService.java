package com.zmo.dbconnect.service;

import com.zmo.dbconnect.dto.ActorDto;
import com.zmo.dbconnect.model.Actor;
import com.zmo.dbconnect.repository.ActorRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;

@Service
public record ActorService(ActorRepository actorRepository) {
    public void registerActor(ActorDto actorDto) {
        Actor actor = Actor.builder()
                .firstName(actorDto.getFirstName())
                .lastName(actorDto.getLastName())
                .lastUpdate(Timestamp.from(Instant.now()))
                .build();
        //todo: check if firstName and lastName is not taken
        actorRepository.save(actor);
    }
}
