package com.denizozgun.hotel_booking_project.service;


import com.denizozgun.hotel_booking_project.dto.RoomDto;
import com.denizozgun.hotel_booking_project.dto.requests.NewRoomDto;
import com.denizozgun.hotel_booking_project.specification.RoomFilter;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public interface RoomService {
    Page<RoomDto> findAll(int page, int size, RoomFilter filter);

    Page<RoomDto> findAll(int page, int size);

    Page<RoomDto> findAllByHotelId(int page, int size, Long hotelId);

    ResponseEntity<RoomDto> findById(Long id);

    ResponseEntity<RoomDto> save(NewRoomDto newRoomDto, Long hotelId);

    HttpStatus deleteById(Long id);
}
