package com.lyubich.toolrental.service;

import com.lyubich.toolrental.dto.ToolType;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class PricingService {

  public BigDecimal calculateFullCharge(ToolType toolType, int chargeDays) {
    return toolType.getDailyCharge().multiply(BigDecimal.valueOf(chargeDays)).setScale(2, RoundingMode.HALF_UP);
  }

  // Pre-discount charge - Calculated as charge days X daily charge. Resulting total rounded half up to cents.
  public BigDecimal calculateDiscount(BigDecimal charge, int discountPercent) {
    if (discountPercent <= 0) {
      return BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
    }

    BigDecimal discountRate = new BigDecimal(discountPercent).divide(new BigDecimal(100), 4, RoundingMode.HALF_UP);
    return charge.multiply(discountRate).setScale(2, RoundingMode.HALF_UP);
  }

  public BigDecimal calculateFinalCharge(BigDecimal charge, BigDecimal discountAmount) {
    return charge.subtract(discountAmount).setScale(2, RoundingMode.HALF_UP);
  }
}
