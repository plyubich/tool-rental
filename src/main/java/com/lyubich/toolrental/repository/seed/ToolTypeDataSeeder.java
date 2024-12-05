package com.lyubich.toolrental.repository.seed;

import com.lyubich.toolrental.dto.ToolType;
import com.lyubich.toolrental.repository.ToolTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Order(1)
public class ToolTypeDataSeeder implements CommandLineRunner {

  @Autowired
  private ToolTypeRepository toolTypeRepository;

  @Override
  public void run(String... args) {
    seedToolTypes();
  }

  private void seedToolTypes() {
    if (toolTypeRepository.count() == 0) {
      toolTypeRepository.save(new ToolType("LADDER", new BigDecimal("1.99"), true, true, false));
      toolTypeRepository.save(new ToolType("CHAINSAW", new BigDecimal("1.49"), true, false, true));
      toolTypeRepository.save(new ToolType("JACKHAMMER", new BigDecimal("2.99"), true, false, false));
    }
  }
}
