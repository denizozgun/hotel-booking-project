package com.denizozgun.hotel_booking_project.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoomDto {

    private long id;
    private long internalId;
    private HotelDto hotel;
    private String name;
    private int beds;
    private int capacity;
    private BigDecimal price;

}
