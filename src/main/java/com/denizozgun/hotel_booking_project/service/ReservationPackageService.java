package com.denizozgun.hotel_booking_project.service;


import com.denizozgun.hotel_booking_project.dto.ReservationPackageDto;
import com.denizozgun.hotel_booking_project.dto.requests.NewReservationPackageDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ReservationPackageService {

    List<ReservationPackageDto> getAllReservationPackages();

    ResponseEntity<ReservationPackageDto> getReservationPackageById(Long id);

    ResponseEntity<List<ReservationPackageDto>> createReservationPackage(NewReservationPackageDto newReservationPackageDto);

    HttpStatus deleteReservationPackageById(Long id);
}
