package com.lyubich.toolrental.config;

import com.lyubich.toolrental.repository.seed.ToolDataSeeder;
import com.lyubich.toolrental.repository.seed.ToolTypeDataSeeder;
import org.junit.jupiter.api.Order;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig {
  @Bean
  @Order(1)
  public CommandLineRunner toolTypeDataLoader(ToolTypeDataSeeder seeder) {
    return args -> seeder.run(args);
  }

  @Bean
  @Order(2)
  public CommandLineRunner toolDataLoader(ToolDataSeeder seeder) {
    return args -> seeder.run(args);
  }
}
