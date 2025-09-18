package com.denizozgun.hotel_booking_project.mapper;

import com.denizozgun.hotel_booking_project.dto.ServiceDto;
import com.denizozgun.hotel_booking_project.entity.Service;

public class ServiceMapper {

    public static ServiceDto map(Service service) {
        return ServiceDto.builder()
                .id(service.getId())
                .name(service.getName())
                .build();
    }

    public static Service convertToEntity(ServiceDto service) {
        return Service.builder()
                .id(service.getId())
                .name(service.getName())
                .build();
    }
}
