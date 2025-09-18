package com.denizozgun.hotel_booking_project.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RatingDto {

    private long id;
    private HotelDto hotel;
    private UserDto user;
    private double rating;

}
