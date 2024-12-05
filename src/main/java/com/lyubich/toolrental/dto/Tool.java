package com.lyubich.toolrental.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tools")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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

  @Override
  public String toString() {
    return "Tool{" +
        "code='" + code + '\'' +
        ", type=" + (type != null ? type.getName() : "null") +
        ", brand='" + brand + '\'' +
        '}';
  }
}
