package com.lyubich.toolrental.service;

import com.lyubich.toolrental.dto.ToolType;
import com.lyubich.toolrental.repository.ToolTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToolTypeService {

  private final ToolTypeRepository toolTypeRepository;

  @Autowired
  public ToolTypeService(ToolTypeRepository toolTypeRepository) {
    this.toolTypeRepository = toolTypeRepository;
  }

  public ToolType findById(String toolCode) {
    return toolTypeRepository.findByName(toolCode);
  }
}
