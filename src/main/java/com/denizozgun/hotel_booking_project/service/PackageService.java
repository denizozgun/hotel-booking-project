package com.denizozgun.hotel_booking_project.service;

import com.denizozgun.hotel_booking_project.dto.PackageDto;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


public interface PackageService {

    Page<PackageDto> getAllPackages(int page, int size);

    ResponseEntity<PackageDto> getPackageById(Long id);

    ResponseEntity<PackageDto> createPackage(String name);

    HttpStatus deletePackage(Long id);
}
