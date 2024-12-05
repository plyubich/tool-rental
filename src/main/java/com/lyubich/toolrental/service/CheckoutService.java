package com.lyubich.toolrental.service;

import com.lyubich.toolrental.exception.RentalException;
import com.lyubich.toolrental.dto.RentalAgreement;
import com.lyubich.toolrental.dto.Tool;
import com.lyubich.toolrental.dto.ToolType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class CheckoutService {

  private final PricingService pricingService;
  private final ChargeableDaysService chargeableDaysService;
  private final ToolTypeService toolTypeService;
  private final ToolService toolService;

  @Autowired
  public CheckoutService(PricingService pricingService, ChargeableDaysService chargeableDaysService, ToolTypeService toolTypeService, ToolService toolService) {
    this.pricingService = pricingService;
    this.chargeableDaysService = chargeableDaysService;
    this.toolTypeService = toolTypeService;
    this.toolService = toolService;
  }

  public RentalAgreement checkout(String toolCode, int rentalDays, int discountPercent, LocalDate checkoutDate) throws RentalException {
    Tool tool;
    try {
      tool = toolService.findById(toolCode);
    } catch (RentalException e) {
      throw new RentalException("Unable to process checkout, tool not found: " + e.getMessage());
    }

    ToolType toolType;
    try {
      toolType = toolTypeService.findById(tool.getType().getName());
    } catch (RentalException e) {
      throw new RentalException("Unable to process checkout: Tool type not found for tool " + toolCode);
    }

    try {
      if (rentalDays < 1) {
        throw new RentalException("Rental days must be 1 or more");
      }

      if (discountPercent < 0 || discountPercent > 100) {
        throw new RentalException("Discount percent must be between 0 and 100");
      }

      int chargeDays = chargeableDaysService.calculateChargeDays(toolType, checkoutDate, rentalDays);

      BigDecimal preDiscountCharge = pricingService.calculateFullCharge(toolType, chargeDays);
      BigDecimal discountAmount = pricingService.calculateDiscount(preDiscountCharge, discountPercent);
      BigDecimal finalCharge = pricingService.calculateFinalCharge(preDiscountCharge, discountAmount);

      return new RentalAgreement(
          tool,
          toolType,
          checkoutDate,
          checkoutDate.plusDays(rentalDays),
          toolType.getDailyCharge(),
          rentalDays,
          chargeDays,
          preDiscountCharge,
          discountPercent,
          discountAmount,
          finalCharge
      );
    } catch (RentalException e) {
      throw e;
    } catch (Exception e) {
      throw new RentalException("An error occurred during checkout: " + e.getMessage());
    }
  }
}
