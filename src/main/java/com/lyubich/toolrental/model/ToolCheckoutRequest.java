package com.lyubich.toolrental.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ToolCheckoutRequest {
  @JsonProperty("tool_code")
  private String toolCode;

  @JsonProperty("rental_days")
  private int rentalDays;

  @JsonProperty("discount_percent")
  private int discountPercent;

  @JsonProperty("checkout_date")
  private LocalDate checkoutDate;
}
