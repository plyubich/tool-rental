package com.lyubich.toolrental.service;

import com.lyubich.toolrental.dto.Tool;
import com.lyubich.toolrental.exception.RentalException;
import com.lyubich.toolrental.repository.ToolRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ToolService {

  private final ToolRepository toolRepository;

  public List<Tool> getAllToolTypes() {
    return toolRepository.findAll();
  }

  public Tool findById(String toolCode) throws RentalException {
    return toolRepository.findById(toolCode)
        .orElseThrow(() -> new RentalException("Tool not found with code: " + toolCode));
  }

  public List<Tool> findAllById(List<String> toolCodes) {
    return toolRepository.findAllById(toolCodes);
  }
}
