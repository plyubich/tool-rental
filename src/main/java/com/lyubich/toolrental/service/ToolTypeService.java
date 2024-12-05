package com.lyubich.toolrental.service;

import com.lyubich.toolrental.dto.ToolType;
import com.lyubich.toolrental.repository.ToolTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ToolTypeService {

  private final ToolTypeRepository toolTypeRepository;

  public ToolType findById(String toolCode) {
    return toolTypeRepository.findByName(toolCode);
  }
}
