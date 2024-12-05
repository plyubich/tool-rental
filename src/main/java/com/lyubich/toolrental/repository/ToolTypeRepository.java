package com.lyubich.toolrental.repository;

import com.lyubich.toolrental.dto.ToolType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface ToolTypeRepository extends JpaRepository<ToolType, Long> {

  ToolType findByName(String name);
}
