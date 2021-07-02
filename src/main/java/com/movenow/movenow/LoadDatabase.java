package com.movenow.movenow;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.movenow.movenow.domain.Move;
import com.movenow.movenow.domain.MoveRepository;

@Configuration
public class LoadDatabase {
  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  
  @Bean
  CommandLineRunner initDatabase(MoveRepository moveRepository) {

    return args -> {
      log.info("Preloading " + moveRepository.save(new Move()));
      log.info("Preloading " + moveRepository.save(new Move()));
    };
  }
}


