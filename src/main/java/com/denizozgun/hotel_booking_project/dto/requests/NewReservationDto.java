package com.denizozgun.hotel_booking_project.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class NewReservationDto {

    private Long userId;
    private Long roomId;
    private String start;
    private String end;

}
