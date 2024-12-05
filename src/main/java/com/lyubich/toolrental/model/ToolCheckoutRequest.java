package com.lyubich.toolrental.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class ToolCheckoutRequest {
  private String toolCode;
  private int rentalDays;
  private int discountPercent;
  private LocalDate checkoutDate;
}
