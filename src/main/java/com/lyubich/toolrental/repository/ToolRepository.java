package com.lyubich.toolrental.repository;

import com.lyubich.toolrental.dto.Tool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface ToolRepository extends JpaRepository<Tool, String> {
  Tool findByCode(String toolCode);
}
