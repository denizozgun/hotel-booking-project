package com.denizozgun.hotel_booking_project.middleware.exceptions;

import lombok.Getter;

@Getter
public class ErrorResponse {
    private final String message;

    public ErrorResponse(String message) {
        this.message = message;
    }

}
