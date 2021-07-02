package com.movenow.movenow;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.movenow.movenow.domain.User;
import com.movenow.movenow.domain.UserRepository;

@Configuration
public class LoadDatabase {
  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  
  @Bean
  CommandLineRunner initDatabase(UserRepository userRepository) {

    return args -> {
    	log.info("Preloading " + userRepository.save(new User(1L, "Dominik", "M", "clockRight" )));
    	log.info("Preloading " + userRepository.save(new User(2L, "Matthias", "W", "kirbby")));
    	
    };
  }
}


