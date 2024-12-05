package com.lyubich.toolrental.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "tool_types")
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

  public ToolType() {
  }

  public ToolType(String name, BigDecimal dailyCharge, boolean weekdayCharge, boolean weekendCharge, boolean holidayCharge) {
    this.name = name;
    this.dailyCharge = dailyCharge;
    this.weekdayCharge = weekdayCharge;
    this.weekendCharge = weekendCharge;
    this.holidayCharge = holidayCharge;
  }

  public String getName() {
    return name;
  }

  public void setName(String id) {
    this.name = id;
  }

  public BigDecimal getDailyCharge() {
    return dailyCharge;
  }

  public void setDailyCharge(BigDecimal dailyCharge) {
    this.dailyCharge = dailyCharge;
  }

  public boolean isWeekdayCharge() {
    return weekdayCharge;
  }

  public void setWeekdayCharge(boolean weekdayCharge) {
    this.weekdayCharge = weekdayCharge;
  }

  public boolean isWeekendCharge() {
    return weekendCharge;
  }

  public void setWeekendCharge(boolean weekendCharge) {
    this.weekendCharge = weekendCharge;
  }

  public boolean isHolidayCharge() {
    return holidayCharge;
  }

  public void setHolidayCharge(boolean holidayCharge) {
    this.holidayCharge = holidayCharge;
  }
}
