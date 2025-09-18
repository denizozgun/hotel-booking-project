package com.denizozgun.hotel_booking_project.mapper;


import com.denizozgun.hotel_booking_project.dto.ReservationDto;
import com.denizozgun.hotel_booking_project.entity.Reservation;

public class ReservationMapper {

    public static ReservationDto map(Reservation reservation) {
        return ReservationDto.builder()
                .id(reservation.getId())
                .user(UserMapper.map(reservation.getUser()))
                .room(RoomMapper.map(reservation.getRoom()))
                .date(reservation.getDate())
                .createdAt(reservation.getCreatedAt())
                .build();

    }

    public static Reservation convertToEntity(ReservationDto reservation) {
        return Reservation.builder()
                .id(reservation.getId())
                .user(UserMapper.convertToEntity(reservation.getUser()))
                .room(RoomMapper.convertToEntity(reservation.getRoom()))
                .date(reservation.getDate())
                .createdAt(reservation.getCreatedAt())
                .build();

    }
}
