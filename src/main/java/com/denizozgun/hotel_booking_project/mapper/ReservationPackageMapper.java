package com.denizozgun.hotel_booking_project.mapper;


import com.denizozgun.hotel_booking_project.dto.ReservationPackageDto;
import com.denizozgun.hotel_booking_project.entity.ReservationPackage;

public class ReservationPackageMapper {

    public static ReservationPackageDto map(ReservationPackage reservationPackage) {

        return ReservationPackageDto.builder()
                .id(reservationPackage.getId())
                .reservation(ReservationMapper.map(reservationPackage.getReservation()))
                .aPackage(PackageMapper.map(reservationPackage.getAPackage()))
                .build();
    }

    public static ReservationPackage convertToEntity(ReservationPackageDto reservationPackage) {

        return ReservationPackage.builder()
                .id(reservationPackage.getId())
                .reservation(ReservationMapper.convertToEntity(reservationPackage.getReservation()))
                .aPackage(PackageMapper.convertToEntity(reservationPackage.getAPackage()))
                .build();
    }
}
