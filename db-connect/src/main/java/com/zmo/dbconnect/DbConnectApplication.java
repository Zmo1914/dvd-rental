package com.zmo.dbconnect;

import com.zmo.dbconnect.repositories.ActorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
        };
    }

}
