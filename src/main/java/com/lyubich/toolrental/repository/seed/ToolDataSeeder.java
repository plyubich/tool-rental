package com.lyubich.toolrental.repository.seed;

import com.lyubich.toolrental.dto.Tool;
import com.lyubich.toolrental.dto.ToolType;
import com.lyubich.toolrental.repository.ToolRepository;
import com.lyubich.toolrental.repository.ToolTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@Order(2)
public class ToolDataSeeder implements CommandLineRunner {

  @Autowired
  private ToolRepository toolRepository;

  @Autowired
  private ToolTypeRepository toolTypeRepository;

  @Override
  public void run(String... args) {
    seedTools();
  }

  private void seedTools() {
    if (toolRepository.count() == 0) {
      ToolType chainsaw = toolTypeRepository.findByName("CHAINSAW");
      ToolType ladder = toolTypeRepository.findByName("LADDER");
      ToolType jackhammer = toolTypeRepository.findByName("JACKHAMMER");

      if (chainsaw != null && ladder != null && jackhammer != null) {
        List<Tool> tools = Arrays.asList(
            new Tool("CHNS", chainsaw, "Stihl"),
            new Tool("LADW", ladder, "Werner"),
            new Tool("JAKD", jackhammer, "DeWalt"),
            new Tool("JAKR", jackhammer, "Ridgid")
        );
        toolRepository.saveAll(tools);
      } else {
        System.out.println("Error: One or more ToolTypes not found. Tools not seeded.");
      }
    }
  }
}
