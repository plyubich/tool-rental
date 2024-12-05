package com.lyubich.toolrental.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tools")
public class Tool {

  @Id
  @Column(name = "code", length = 4)
  private String code;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "tool_type_name", referencedColumnName = "name", nullable = false)
  @NotNull
  private ToolType type;

  @Column(nullable = false)
  @NotNull
  private String brand;

  public Tool(String toolCode, ToolType toolType, String brand) {
    this.code = toolCode;
    this.type = toolType;
    this.brand = brand;
  }

  public Tool() {
  }

  // Getters and setters remain the same

  @Override
  public String toString() {
    return "Tool{" +
        "code='" + code + '\'' +
        ", type=" + (type != null ? type.getName() : "null") +
        ", brand='" + brand + '\'' +
        '}';
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public @NotNull ToolType getType() {
    return type;
  }

  public void setType(@NotNull ToolType type) {
    this.type = type;
  }

  public @NotNull String getBrand() {
    return brand;
  }

  public void setBrand(@NotNull String brand) {
    this.brand = brand;
  }
}
