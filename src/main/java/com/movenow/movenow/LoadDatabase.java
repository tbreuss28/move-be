package com.movenow.movenow;

import com.movenow.movenow.domain.User;
import com.movenow.movenow.domain.UserRepository;
import com.movenow.movenow.domain.move.Move;
import com.movenow.movenow.domain.move.MoveRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Instant;
import java.util.Date;
import java.util.Random;

@Configuration
public class LoadDatabase {
  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  
  @Bean
  CommandLineRunner initDatabase(UserRepository userRepository, MoveRepository moveRepository) {
	  	
    return args -> {
    	log.info("Preloading user clockright" + userRepository.save(new User("Dominik", "M", "clockRight" )));
    	log.info("Preloading user kirbby" + userRepository.save(new User("Matthias", "W", "kirbby")));
        log.info("Preloading move 1" + moveRepository.save(new Move(
        		"Lauftreff Leiblachtal", 
        		"Wöchentlicher Lauftreff für alle aus dem Leiblachtal.", 
        		Date.from(Instant.parse("2021-07-03T14:00:00Z")), 
        		Date.from(Instant.parse("2021-07-03T15:00:00Z")), 
        		47.500897D, 
        		9.745009D,
        		1L,
				GetRandomNumber(1L, 3L))));
        log.info("Preloading move 2" + moveRepository.save(new Move(
        		"HobbyKick Bregenz", 
        		"Tschutta in Neu Amerika", 
        		Date.from(Instant.parse("2021-07-03T16:00:00Z")), 
        		Date.from(Instant.parse("2021-07-03T18:00:00Z")), 
        		47.503406D, 
        		9.711289D,
				GetRandomNumber(1L, 10L),
				GetRandomNumber(1L, 3L))));
        log.info("Preloading move 3" + moveRepository.save(new Move("Tennis am Mittag", 
        		"Bewegung in der Mittagspause", 
        		Date.from(Instant.parse("2021-07-03T16:00:00Z")), 
        		Date.from(Instant.parse("2021-07-03T17:00:00Z")), 
        		47.505227D, 
        		9.728391D,
				GetRandomNumber(1L, 10L),
				GetRandomNumber(1L, 3L))));
    };
  }
  
  private Long GetRandomNumber(Long minValue, Long maxValue){
  	var random = new Random();
  	var number = random.nextInt((int)(maxValue - minValue));
	  
  	return Long.valueOf(number);
  }
}


