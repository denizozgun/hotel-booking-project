package com.denizozgun.hotel_booking_project.mapper;


import com.denizozgun.hotel_booking_project.dto.HotelDto;
import com.denizozgun.hotel_booking_project.entity.Hotel;

public class HotelMapper {

    public static HotelDto map(Hotel entity) {
        return HotelDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .city(entity.getCity())
                .address(entity.getAddress())
                .rating(entity.getRating())
                .build();

    }

    public static Hotel convertToEntity(HotelDto dto) {
        return Hotel.builder()
                .id(dto.getId())
                .name(dto.getName())
                .city(dto.getCity())
                .address(dto.getAddress())
                .rating(dto.getRating())
                .build();

    }
}
