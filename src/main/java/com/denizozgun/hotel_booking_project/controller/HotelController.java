package com.denizozgun.hotel_booking_project.controller;


import com.denizozgun.hotel_booking_project.dto.HotelDto;
import com.denizozgun.hotel_booking_project.service.HotelService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/hotels")
public class HotelController {

    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping
    public Page<HotelDto> getAllHotels(@RequestParam(name = "page", defaultValue = "0") int page,
                                       @RequestParam(name = "size", defaultValue = "10") int size) {
        return hotelService.findAll(page, size);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HotelDto> getHotelById(@PathVariable Long id) {
        return hotelService.findById(id);
    }

    @PostMapping("/new")
    public ResponseEntity<HotelDto> createHotel(@RequestBody HotelDto hotelDto) {
        return hotelService.save(hotelDto);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteHotel(@PathVariable Long id) {
        return hotelService.deleteById(id);
    }
}
