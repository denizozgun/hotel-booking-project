package com.denizozgun.hotel_booking_project.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PackageServiceDto {
    private long id;
    private PackageDto packageDto;
    private ServiceDto serviceDto;
}
