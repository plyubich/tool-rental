package com.lyubich.toolrental;

import com.lyubich.toolrental.dto.RentalAgreement;
import com.lyubich.toolrental.model.RentalAgreementResponse;
import com.lyubich.toolrental.service.CheckoutService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class ToolRentalApplication {

  public static void main(String[] args) {
    ConfigurableApplicationContext context = SpringApplication.run(ToolRentalApplication.class, args);

    if (args.length < 3) {
      System.out.println("Usage: java -jar your-app.jar <toolCode> <rentalDays> <discountPercent>");
      return;
    }

    try {
      // Parse command-line arguments
      String toolCode = args[0];
      int rentalDays = Integer.parseInt(args[1]);
      int discountPercent = Integer.parseInt(args[2]);
      LocalDate checkoutDate = LocalDate.of(2024, 12, 1);

      // Get CheckoutService bean
      CheckoutService checkoutService = context.getBean(CheckoutService.class);

      // Perform checkout
      RentalAgreement agreement = checkoutService.checkout(toolCode, rentalDays, discountPercent, checkoutDate);
      RentalAgreementResponse response = new RentalAgreementResponse(
          agreement.getTool().getCode(),
          agreement.getTool().getType().getName(),
          agreement.getTool().getBrand(),
          agreement.getRentalDays(),
          agreement.getCheckoutDate().toString(),
          agreement.getDueDate().toString(),
          agreement.getDailyRentalCharge().doubleValue(),
          agreement.getChargeDays(),
          agreement.getPreDiscountCharge().doubleValue(),
          agreement.getDiscountPercent(),
          agreement.getDiscountAmount().doubleValue(),
          agreement.getFinalCharge().doubleValue()
      );

      System.out.println("\n\nRental Agreement:\n" + response.toString());

    } catch (NumberFormatException e) {
      System.out.println("Error: Invalid number format for rental days or discount percent.");
    } catch (Exception e) {
      System.out.println("An error occurred: " + e.getMessage());
      e.printStackTrace();
    } finally {
      context.close();
    }
  }
}
