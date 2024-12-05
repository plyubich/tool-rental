package com.lyubich.toolrental.controller;

import com.lyubich.toolrental.dto.RentalAgreement;
import com.lyubich.toolrental.exception.RentalException;
import com.lyubich.toolrental.model.RentalAgreementResponse;
import com.lyubich.toolrental.model.ToolCheckoutRequest;
import com.lyubich.toolrental.model.ToolCheckoutResponse;
import com.lyubich.toolrental.service.CheckoutService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/rentals/tools")
@AllArgsConstructor
public class RentalController {

  private final CheckoutService checkoutService;

  private static ToolCheckoutResponse getResponse(RentalAgreement agreement) {
    RentalAgreementResponse responseRentalAgreement = new RentalAgreementResponse(
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

    ToolCheckoutResponse response = new ToolCheckoutResponse(responseRentalAgreement, true, "Checkout successful");

    System.out.println("Response: " + response);
    return response;
  }

  @PostMapping(value = "/checkout", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<ToolCheckoutResponse> checkout(@RequestBody ToolCheckoutRequest request) throws RentalException {
    System.out.println("Request: " + request);
    try {
      RentalAgreement agreement = checkoutService.checkout(
          request.getToolCode(),
          request.getRentalDays(),
          request.getDiscount(),
          request.getCheckoutDate()
      );

      ToolCheckoutResponse response = getResponse(agreement);
      return ResponseEntity.ok(response);
    } catch (RentalException | IllegalArgumentException e) {
      System.out.println(e);
      RentalException errorResponse = new RentalException(e.getMessage());
      return ResponseEntity.badRequest().body(new ToolCheckoutResponse(null, false, errorResponse.getMessage()));
    } catch (Exception e) {
      System.out.println(e);
      RentalException errorResponse = new RentalException("An unexpected error occurred");
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ToolCheckoutResponse(null, false, errorResponse.getMessage()));
    }
  }
}
