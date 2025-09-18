package com.denizozgun.hotel_booking_project.service;

import com.denizozgun.hotel_booking_project.dto.HotelDto;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


public interface HotelService {
    Page<HotelDto> findAll(int page, int size);

    ResponseEntity<HotelDto> findById(Long id);

    ResponseEntity<HotelDto> save(HotelDto dto);

    HttpStatus deleteById(Long id);
}
