package com.denizozgun.hotel_booking_project.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReservationPackageDto {
    private long id;
    private ReservationDto reservation;
    private PackageDto aPackage;
}
