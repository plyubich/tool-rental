package com.lyubich.toolrental.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ToolCheckoutResponse {
    @JsonProperty("agreement")
    private RentalAgreementResponse agreement;

    @JsonProperty("success")
    private boolean success;

    @JsonProperty("message")
    private String message;
}
