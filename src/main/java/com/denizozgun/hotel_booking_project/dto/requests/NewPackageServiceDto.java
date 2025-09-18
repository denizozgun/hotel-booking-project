package com.denizozgun.hotel_booking_project.dto.requests;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NewPackageServiceDto {
    private Long packageId;
    private Long[] serviceId;
}
