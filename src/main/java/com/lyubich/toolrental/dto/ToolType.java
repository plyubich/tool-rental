package com.lyubich.toolrental.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "tool_types")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ToolType {

  @Id
  @Column(name = "name", length = 15)
  private String name;

  @Column(nullable = false)
  private BigDecimal dailyCharge;

  @Column(nullable = false)
  private boolean weekdayCharge;

  @Column(nullable = false)
  private boolean weekendCharge;

  @Column(nullable = false)
  private boolean holidayCharge;
}
