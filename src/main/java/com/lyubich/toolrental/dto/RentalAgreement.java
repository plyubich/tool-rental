package com.lyubich.toolrental.dto;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Entity
@Table(name = "rental_agreements")
public class RentalAgreement {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
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

  // Constructors
  public RentalAgreement() {
  }

  public RentalAgreement(
      Tool tool,
      ToolType toolType,
      LocalDate checkoutDate,
      LocalDate dueDate,
      BigDecimal dailyRentalCharge,
      int rentalDays,
      int chargeDays,
      BigDecimal preDiscountCharge,
      int discountPercent,
      BigDecimal discountAmount,
      BigDecimal finalCharge) {
    this.tool = tool;
    this.toolType = toolType;
    this.checkoutDate = checkoutDate;
    this.dueDate = dueDate;
    this.dailyRentalCharge = dailyRentalCharge;
    this.rentalDays = rentalDays;
    this.chargeDays = chargeDays;
    this.preDiscountCharge = preDiscountCharge;
    this.discountPercent = discountPercent;
    this.discountAmount = discountAmount;
    this.finalCharge = finalCharge;
  }

  // Getters and setters for all fields
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Tool getTool() {
    return tool;
  }

  public void setTool(Tool tool) {
    this.tool = tool;
  }

  public int getRentalDays() {
    return rentalDays;
  }

  public void setRentalDays(int rentalDays) {
    this.rentalDays = rentalDays;
  }

  public LocalDate getCheckoutDate() {
    return checkoutDate;
  }

  public void setCheckoutDate(LocalDate checkoutDate) {
    this.checkoutDate = checkoutDate;
  }

  public LocalDate getDueDate() {
    return dueDate;
  }

  public void setDueDate(LocalDate dueDate) {
    this.dueDate = dueDate;
  }

  public BigDecimal getDailyRentalCharge() {
    return dailyRentalCharge;
  }

  public void setDailyRentalCharge(BigDecimal dailyRentalCharge) {
    this.dailyRentalCharge = dailyRentalCharge;
  }

  public int getChargeDays() {
    return chargeDays;
  }

  public void setChargeDays(int chargeDays) {
    this.chargeDays = chargeDays;
  }

  public BigDecimal getPreDiscountCharge() {
    return preDiscountCharge;
  }

  public void setPreDiscountCharge(BigDecimal preDiscountCharge) {
    this.preDiscountCharge = preDiscountCharge;
  }

  public int getDiscountPercent() {
    return discountPercent;
  }

  public void setDiscountPercent(int discountPercent) {
    this.discountPercent = discountPercent;
  }

  public BigDecimal getDiscountAmount() {
    return discountAmount;
  }

  public void setDiscountAmount(BigDecimal discountAmount) {
    this.discountAmount = discountAmount;
  }

  public BigDecimal getFinalCharge() {
    return finalCharge;
  }

  public void setFinalCharge(BigDecimal finalCharge) {
    this.finalCharge = finalCharge;
  }

  public String toString() {
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yy");
    NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(Locale.US);
    NumberFormat percentFormatter = NumberFormat.getPercentInstance(Locale.US);
    percentFormatter.setMinimumFractionDigits(0);
    percentFormatter.setMaximumFractionDigits(0);

    StringBuilder sb = new StringBuilder();
    sb.append("Tool code: ").append(tool.getCode()).append("\n");
    sb.append("Tool type: ").append(toolType.getName()).append("\n");
    sb.append("Tool brand: ").append(tool.getBrand()).append("\n");
    sb.append("Rental days: ").append(rentalDays).append("\n");
    sb.append("Check out date: ").append(dateFormatter.format(checkoutDate)).append("\n");
    sb.append("Due date: ").append(dateFormatter.format(dueDate)).append("\n");
    sb.append("Daily rental charge: ").append(currencyFormatter.format(dailyRentalCharge)).append("\n");
    sb.append("Charge days: ").append(chargeDays).append("\n");
    sb.append("Pre-discount charge: ").append(currencyFormatter.format(preDiscountCharge)).append("\n");
    sb.append("Discount percent: ").append(percentFormatter.format(discountPercent / 100.0)).append("\n");
    sb.append("Discount amount: ").append(currencyFormatter.format(discountAmount)).append("\n");
    sb.append("Final charge: ").append(currencyFormatter.format(finalCharge));

    return sb.toString();
  }
}
