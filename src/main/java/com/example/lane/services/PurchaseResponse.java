package com.example.lane.services;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
public class PurchaseResponse {
    private final String orderTrackingNumber;

    public PurchaseResponse(String orderTrackingNumber) {
        this.orderTrackingNumber = orderTrackingNumber;
    }

    public static PurchaseResponse withManualTrackingNumber(String trackingNumber) {
        return new PurchaseResponse(trackingNumber);
    }
}
