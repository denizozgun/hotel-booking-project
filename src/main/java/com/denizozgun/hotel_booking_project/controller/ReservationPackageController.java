package com.denizozgun.hotel_booking_project.controller;


import com.denizozgun.hotel_booking_project.dto.ReservationPackageDto;
import com.denizozgun.hotel_booking_project.dto.requests.NewReservationPackageDto;
import com.denizozgun.hotel_booking_project.service.ReservationPackageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservation-package")
public class ReservationPackageController {

    private final ReservationPackageService reservationPackageService;

    public ReservationPackageController(ReservationPackageService reservationPackageService) {
        this.reservationPackageService = reservationPackageService;
    }

    @GetMapping
    public List<ReservationPackageDto> getAllReservationPackages() {
        return reservationPackageService.getAllReservationPackages();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservationPackageDto> getReservationPackageById(@PathVariable Long id) {
        return reservationPackageService.getReservationPackageById(id);
    }

    @PostMapping
    public ResponseEntity<List<ReservationPackageDto>> createReservationPackage(@RequestBody NewReservationPackageDto newReservationPackageDto) {
        return reservationPackageService.createReservationPackage(newReservationPackageDto);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteReservationPackageById(@PathVariable("id") Long id) {
        return reservationPackageService.deleteReservationPackageById(id);
    }
}
