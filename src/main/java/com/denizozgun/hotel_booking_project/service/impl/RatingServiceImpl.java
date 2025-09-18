package com.denizozgun.hotel_booking_project.service.impl;


import com.denizozgun.hotel_booking_project.middleware.exceptions.WillfulException;
import com.denizozgun.hotel_booking_project.dto.HotelDto;
import com.denizozgun.hotel_booking_project.dto.RatingDto;
import com.denizozgun.hotel_booking_project.dto.UserDto;
import com.denizozgun.hotel_booking_project.dto.requests.NewRatingDto;
import com.denizozgun.hotel_booking_project.entity.Rating;
import com.denizozgun.hotel_booking_project.mapper.HotelMapper;
import com.denizozgun.hotel_booking_project.mapper.RatingMapper;
import com.denizozgun.hotel_booking_project.mapper.UserMapper;
import com.denizozgun.hotel_booking_project.repository.RatingRepository;
import com.denizozgun.hotel_booking_project.service.HotelService;
import com.denizozgun.hotel_booking_project.service.RatingService;
import com.denizozgun.hotel_booking_project.service.ReservationService;
import com.denizozgun.hotel_booking_project.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RatingServiceImpl implements RatingService {

    private final RatingRepository ratingRepository;
    private final HotelService hotelService;
    private final UserService userService;
    private final ReservationService reservationService;

    public RatingServiceImpl(RatingRepository ratingRepository, HotelService hotelService, UserService userService, ReservationService reservationService) {
        this.ratingRepository = ratingRepository;
        this.hotelService = hotelService;
        this.userService = userService;
        this.reservationService = reservationService;
    }

    @Override
    public Page<RatingDto> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").ascending());
        Page<Rating> pages = ratingRepository.findAll(pageable);

        return pages.map(RatingMapper::map);
    }

    @Override
    public Page<RatingDto> findAllByUserId(int page, int size, Long userId) {
        userService.findById(userId);
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").ascending());
        Page<Rating> pages = ratingRepository.findAllByUserId(userId, pageable);

        return pages.map(RatingMapper::map);
    }

    @Override
    public Page<RatingDto> findAllByHotelId(int page, int size, Long hotelId) {
        hotelService.findById(hotelId);
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").ascending());
        Page<Rating> pages = ratingRepository.findAllByHotelId(hotelId, pageable);

        return pages.map(RatingMapper::map);
    }

    @Override
    public ResponseEntity<RatingDto> getRatingById(Long id) {
        if(id == null){
            throw new WillfulException("Rating id is null");
        }
        Optional<Rating> optionalRating = ratingRepository.findById(id);

        if (optionalRating.isEmpty()){
            throw new WillfulException("Rating not found (id: " + id + ")");
        }
        RatingDto ratingDto = RatingMapper.map(optionalRating.get());
        return ResponseEntity.ok(ratingDto);
    }

    @Override
    public ResponseEntity<RatingDto> addRating(NewRatingDto newRatingDto) {
        UserDto user = userService.findById(newRatingDto.getUserId()).getBody();
        HotelDto hotel = hotelService.findById(newRatingDto.getHotelId()).getBody();

        assert user != null;
        assert hotel != null;

        if (reservationService.getStays(newRatingDto.getHotelId(), newRatingDto.getUserId()).isEmpty()) {
            throw new WillfulException("No reservation found."); //no reservation, cant review hotel
        }
        if (newRatingDto.getRating() < 0 || newRatingDto.getRating() > 10) {
            throw new WillfulException("Rating must be between 0 and 10.");
        }

        Optional<Rating> existing = ratingRepository.findRatingByHotelIdAndUserId(newRatingDto.getHotelId(), newRatingDto.getUserId());
        Rating existingOrNewRating;
        if (existing.isPresent()) {
            existingOrNewRating = existing.get();
            existingOrNewRating.setRating(newRatingDto.getRating());
            existingOrNewRating = ratingRepository.save(existingOrNewRating);
        } else {
            existingOrNewRating = Rating.builder()
                    .hotel(HotelMapper.convertToEntity(hotel))
                    .user(UserMapper.convertToEntity(user))
                    .rating(newRatingDto.getRating())
                    .build();

            existingOrNewRating = ratingRepository.save(existingOrNewRating);
        }

        hotel.setRating(ratingRepository.avgRatingByHotelId(newRatingDto.getHotelId()));
        hotelService.save(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(RatingMapper.map(existingOrNewRating));
    }

    @Override
    public HttpStatus deleteRatingById(Long id) {
        RatingDto rating = getRatingById(id).getBody();
        assert rating != null;
        HotelDto hotel = rating.getHotel();
        hotel.setRating(ratingRepository.avgRatingByHotelId(rating.getHotel().getId()));
        hotelService.save(hotel);
        ratingRepository.deleteById(id);
        return HttpStatus.NO_CONTENT;
    }
}
