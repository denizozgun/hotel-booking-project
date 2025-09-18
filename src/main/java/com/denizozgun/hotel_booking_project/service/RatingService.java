package com.denizozgun.hotel_booking_project.service;

import com.denizozgun.hotel_booking_project.dto.RatingDto;
import com.denizozgun.hotel_booking_project.dto.requests.NewRatingDto;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public interface RatingService {

    Page<RatingDto> findAll(int page, int size);

    Page<RatingDto> findAllByUserId(int page, int size, Long userId);

    Page<RatingDto> findAllByHotelId(int page, int size, Long hotelId);

    ResponseEntity<RatingDto> getRatingById(Long id);

    ResponseEntity<RatingDto> addRating(NewRatingDto newRatingDto);

    HttpStatus deleteRatingById(Long id);

}
