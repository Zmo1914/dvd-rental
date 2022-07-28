package com.zmo.dbconnect.service;

import com.zmo.dbconnect.dto.ActorDto;
import com.zmo.dbconnect.model.Actor;
import com.zmo.dbconnect.repository.ActorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Slf4j
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

    public boolean deleteActorById(Integer actor_id) {
        try {
            actorRepository.deleteById(actor_id);
            return true;
        } catch (EmptyResultDataAccessException e) {
            log.info("Cannot find Actor with ID={}", actor_id);
            log.info("Message: {}", e.getMessage());
            return false;
        }
    }

    public boolean deleteActors(List<Integer> actors_id) {
        int deletedCounter = 0;
        for (int i = 0; i < actors_id.size(); i++) {
            try {
                actorRepository.deleteById(actors_id.get(i));
                deletedCounter++;
            } catch (EmptyResultDataAccessException e) {
                log.info("Cannot find Actor with ID={}", i);
                log.info("Message: {}", e.getMessage());
            }
        }
        if (deletedCounter > 0)
            return true;
        return false;
    }


    public Optional<Actor> getActorById(Integer actor_id) {
        return Optional.ofNullable(actorRepository.findActorById(actor_id));

    }
}
