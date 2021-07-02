package com.movenow.movenow;

import com.movenow.movenow.domain.Move;
import com.movenow.movenow.domain.MoveRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.movenow.movenow.domain.User;
import com.movenow.movenow.domain.UserRepository;

import java.util.Date;

@Configuration
public class LoadDatabase {
  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  
  @Bean
  CommandLineRunner initDatabase(UserRepository userRepository, MoveRepository moveRepository) {

	  
    return args -> {
    	log.info("Preloading user clockright" + userRepository.save(new User("Dominik", "M", "clockRight" )));
    	log.info("Preloading user kirbby" + userRepository.save(new User("Matthias", "W", "kirbby")));

        log.info("Preloading move 1" + moveRepository.save(new Move("Lauftreff Leiblachtal", "Wöchentlicher Lauftreff für alle aus dem Leiblachtal.", new Date(), new Date(), 47.500897D, 9.745009D)));
        log.info("Preloading move 2" + moveRepository.save(new Move("HobbyKick Bregenz", "Tschutta in Neu Amerika", new Date(), new Date(), 47.503406D, 9.711289D)));
        log.info("Preloading move 3" + moveRepository.save(new Move("Tennis am Mittag", "Bewegung in der Mittagspause", new Date(), new Date(), 47.505227D, 9.728391D)));
    };
  }
}


