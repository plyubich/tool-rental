package com.lyubich.toolrental.service;

import com.lyubich.toolrental.config.TestConfig;
import com.lyubich.toolrental.dto.RentalAgreement;
import com.lyubich.toolrental.exception.RentalException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
@Import(TestConfig.class)
class CheckoutServiceTest {

  @Autowired
  private CheckoutService checkoutService;

  @Autowired
  private ToolService toolService;

  @Test
  void testCheckout_ValidInput() {
    // Arrange so that result produces the price for 4 days since 1st is a weekend
    String toolCode = "JAKR";
    int rentalDays = 5;
    int discountPercent = 10;
    LocalDate checkoutDate = LocalDate.of(2024, 12, 1);

    // Act
    RentalAgreement agreement = checkoutService.checkout(toolCode, rentalDays, discountPercent, checkoutDate);

    // Assert
    assertNotNull(agreement);
    assertEquals(toolCode, agreement.getTool().getCode());
    assertEquals(rentalDays, agreement.getRentalDays());
    assertEquals(checkoutDate, agreement.getCheckoutDate());
    assertEquals(LocalDate.of(2024, 12, 1).plusDays(rentalDays), agreement.getDueDate());
    assertEquals(4, agreement.getChargeDays());
    assertEquals(new BigDecimal("2.99"), agreement.getDailyRentalCharge());
    assertEquals(new BigDecimal("11.96"), agreement.getPreDiscountCharge());
    assertEquals(10, agreement.getDiscountPercent());
    assertEquals(new BigDecimal("1.20"), agreement.getDiscountAmount());
    assertEquals(new BigDecimal("10.76"), agreement.getFinalCharge());

    System.out.println(agreement);
  }

  @Test
  void testCheckout_InvalidToolCode() {
    // Arrange so that result produces the price for 4 days since 1st is a weekend
    String toolCode = "JAKR_INVALID";
    int rentalDays = 5;
    int discountPercent = 10;
    LocalDate checkoutDate = LocalDate.of(2024, 12, 1);

    // Act & Assert
    assertThrows(RentalException.class, () ->
        checkoutService.checkout(toolCode, 5, 10, LocalDate.now())
    );
  }

  @Test
  void testCheckout_InvalidRentalDays() {
    // Act & Assert
    assertThrows(RentalException.class, () -> checkoutService.checkout("JAKR", 0, 10, LocalDate.now()));
  }

  @Test
  void testCheckout_InvalidDiscountPercent() {
    // Act & Assert
    assertThrows(RentalException.class, () -> checkoutService.checkout("JAKR", 5, 101, LocalDate.now()));
  }
}
