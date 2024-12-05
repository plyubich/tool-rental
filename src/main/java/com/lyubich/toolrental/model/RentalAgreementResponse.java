package com.lyubich.toolrental.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RentalAgreementResponse {
  @JsonProperty("tool_code")
  private String toolCode;

  @JsonProperty("tool_type")
  private String toolType;

  @JsonProperty("tool_brand")
  private String toolBrand;

  @JsonProperty("rental_days")
  private int rentalDays;

  @JsonProperty("checkout_date")
  private String checkoutDate;

  @JsonProperty("due_date")
  private String dueDate;

  @JsonProperty("daily_rental_charge")
  private double dailyRentalCharge;

  @JsonProperty("charge_days")
  private int chargeDays;

  @JsonProperty("pre_discount_charge")
  private double preDiscountCharge;

  @JsonProperty("discount_percent")
  private int discountPercent;

  @JsonProperty("discount_amount")
  private double discountAmount;

  @JsonProperty("final_charge")
  private double finalCharge;
}
