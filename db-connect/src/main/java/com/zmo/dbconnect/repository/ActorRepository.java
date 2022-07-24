package com.zmo.dbconnect.repository;

import com.zmo.dbconnect.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ActorRepository extends JpaRepository<Actor, Integer> {

    List<Actor> findByFirstName(String firstName);

    Actor findActorById(Integer id);
}