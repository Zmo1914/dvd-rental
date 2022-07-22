package com.zmo.dbconnect;

import com.zmo.dbconnect.model.Actor;
import com.zmo.dbconnect.repository.ActorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class DbConnectApplication {
    public static void main(String[] args) {
        SpringApplication.run(DbConnectApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ActorRepository actorRepository) {
        return args -> {
            //actorRepository.save(new Actor("Emil", "Dinev", Timestamp.from(Instant.now())));
            System.out.println(actorRepository.count());
            List<Actor> listOfActors =  actorRepository.findAll();
            Actor actor = listOfActors.get(4);
            System.out.println("| " + actor.getId() + " | " + actor.getFirstName() + " | " + actor.getLastName() + " | " + actor.getLastUpdate() + " |" );

            List<Actor> newList = actorRepository.findByFirstName("Alan");
            System.out.println(newList.get(0).getFirstName());
        };
    }

}
