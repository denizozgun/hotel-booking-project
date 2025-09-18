package com.denizozgun.hotel_booking_project.service;


import com.denizozgun.hotel_booking_project.dto.ReservationDto;
import com.denizozgun.hotel_booking_project.dto.requests.NewReservationDto;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ReservationService {

    Page<ReservationDto> findAllByUserId(int page, int size, Long userId);

    List<ReservationDto> getStays(Long hotelId, Long userId);

    ResponseEntity<ReservationDto> findByReservationId(Long reservationId);

    ResponseEntity<List<ReservationDto>> save(NewReservationDto newReservationDto);

    HttpStatus cancelReservation(Long reservationId);

    HttpStatus cancelReservation(Long... reservationIds);

}
