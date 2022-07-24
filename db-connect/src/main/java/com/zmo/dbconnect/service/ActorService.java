package com.zmo.dbconnect.service;

import com.zmo.dbconnect.dto.ActorDto;
import com.zmo.dbconnect.model.Actor;
import com.zmo.dbconnect.repository.ActorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;

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

    public boolean deleteActor(Integer id) {
        try {
            actorRepository.deleteById(id);
            return true;
        }catch (EmptyResultDataAccessException e){
            log.info("Cannot find Actor with ID={}",id);
            log.info("Message: {}",e.getMessage());
            return false;
        }
    }
}
