package com.denizozgun.hotel_booking_project.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NewReservationPackageDto {

    private long[] reservationIds;
    private long packageId;
}
