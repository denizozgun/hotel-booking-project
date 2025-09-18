package com.denizozgun.hotel_booking_project.service;

import com.denizozgun.hotel_booking_project.dto.ServiceDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ServiceService {

    List<ServiceDto> getAllServices();

    ResponseEntity<ServiceDto> getServiceById(Long id);

    ResponseEntity<ServiceDto> createService(String name);

    HttpStatus deleteServiceById(Long id);

}
