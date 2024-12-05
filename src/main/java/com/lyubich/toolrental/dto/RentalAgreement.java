package com.lyubich.toolrental.dto;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "rental_agreements")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class RentalAgreement {

  @Id
  @GeneratedValue(strategy = GenerationType.TABLE)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "tool_code", nullable = false)
  private Tool tool;

  @ManyToOne
  @JoinColumn(name = "tool_type_name", nullable = false)
  private ToolType toolType;

  @Column(nullable = false)
  private int rentalDays;

  @Column(nullable = false)
  private LocalDate checkoutDate;

  @Column(nullable = false)
  private LocalDate dueDate;

  @Column(nullable = false, precision = 10, scale = 2)
  private BigDecimal dailyRentalCharge;

  @Column(nullable = false)
  private int chargeDays;

  @Column(nullable = false, precision = 10, scale = 2)
  private BigDecimal preDiscountCharge;

  @Column(nullable = false)
  private int discountPercent;

  @Column(nullable = false, precision = 10, scale = 2)
  private BigDecimal discountAmount;

  @Column(nullable = false, precision = 10, scale = 2)
  private BigDecimal finalCharge;

  @lombok.Builder
  public static RentalAgreement create(
      Tool tool, ToolType toolType, int rentalDays, LocalDate checkoutDate,
      LocalDate dueDate, BigDecimal dailyRentalCharge, int chargeDays,
      BigDecimal preDiscountCharge, int discountPercent,
      BigDecimal discountAmount, BigDecimal finalCharge) {
    RentalAgreement agreement = new RentalAgreement();
    agreement.tool = tool;
    agreement.toolType = toolType;
    agreement.rentalDays = rentalDays;
    agreement.checkoutDate = checkoutDate;
    agreement.dueDate = dueDate;
    agreement.dailyRentalCharge = dailyRentalCharge;
    agreement.chargeDays = chargeDays;
    agreement.preDiscountCharge = preDiscountCharge;
    agreement.discountPercent = discountPercent;
    agreement.discountAmount = discountAmount;
    agreement.finalCharge = finalCharge;
    return agreement;
  }
}
