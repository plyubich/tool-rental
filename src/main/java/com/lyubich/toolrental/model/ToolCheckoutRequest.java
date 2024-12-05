package com.lyubich.toolrental.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
public class ToolCheckoutRequest {
  @JsonProperty("tool_code")
  private String toolCode;
  @JsonProperty("rental_days")
  private int rentalDays;
  @JsonProperty("discount_percent")
  private int discountPercent;
  @JsonProperty("checkout_date")
  private LocalDate checkoutDate;

  public ToolCheckoutRequest(String toolCode, int rentalDays, int discountPercent, LocalDate checkoutDate) {
    this.toolCode = toolCode;
    this.rentalDays = rentalDays;
    this.discountPercent = discountPercent;
    this.checkoutDate = checkoutDate;
  }
}
