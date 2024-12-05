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
public class ToolCheckoutResponse {
    @JsonProperty("agreement")
    private RentalAgreementResponse agreement;

    @JsonProperty("success")
    private boolean success;

    @JsonProperty("message")
    private String message;
}
