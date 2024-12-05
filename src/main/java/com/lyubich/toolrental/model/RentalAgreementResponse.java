package com.lyubich.toolrental.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

  @Override
  public String toString() {
    return String.format(
        "Tool code: %s\n" +
            "Tool type: %s\n" +
            "Tool brand: %s\n" +
            "Rental days: %d\n" +
            "Check out date: %s\n" +
            "Due date: %s\n" +
            "Daily rental charge: $%.2f\n" +
            "Charge days: %d\n" +
            "Pre-discount charge: $%.2f\n" +
            "Discount percent: %d%%\n" +
            "Discount amount: $%.2f\n" +
            "Final charge: $%.2f",
        toolCode, toolType, toolBrand, rentalDays, checkoutDate, dueDate,
        dailyRentalCharge, chargeDays, preDiscountCharge, discountPercent,
        discountAmount, finalCharge
    );
  }
}
