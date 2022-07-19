package com.zmo.dbconnect.repositories;

import com.zmo.dbconnect.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, Integer> {
}