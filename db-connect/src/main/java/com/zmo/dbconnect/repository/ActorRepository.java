package com.zmo.dbconnect.repository;

import com.zmo.dbconnect.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Integer> {

    List<Actor> findByFirstName(String firstName);

    Actor findActorById(Integer id);

    void deleteByIdIn(List<Integer> ids);
}