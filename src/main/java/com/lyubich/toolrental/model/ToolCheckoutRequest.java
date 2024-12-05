package com.lyubich.toolrental.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ToolCheckoutRequest {
  private String toolCode;
  private int rentalDays;
  private int discount;
  private LocalDate checkoutDate;
}
