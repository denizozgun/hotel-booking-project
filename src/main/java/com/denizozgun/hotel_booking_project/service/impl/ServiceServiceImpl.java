package com.denizozgun.hotel_booking_project.service.impl;


import com.denizozgun.hotel_booking_project.middleware.exceptions.WillfulException;
import com.denizozgun.hotel_booking_project.dto.ServiceDto;
import com.denizozgun.hotel_booking_project.mapper.ServiceMapper;
import com.denizozgun.hotel_booking_project.repository.ServiceRepository;
import com.denizozgun.hotel_booking_project.service.ServiceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceServiceImpl implements ServiceService {

    private final ServiceRepository serviceRepository;

    public ServiceServiceImpl(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @Override
    public List<ServiceDto> getAllServices() {
        return serviceRepository.findAll()
                .stream()
                .map(ServiceMapper::map)
                .toList();
    }

    @Override
    public ResponseEntity<ServiceDto> getServiceById(Long id) {

        if(id == null){
            throw new WillfulException("Service id is null");
        }
        Optional<com.denizozgun.hotel_booking_project.entity.Service> optionalService =
                serviceRepository.findById(id);

        if(optionalService.isEmpty()){
            throw new WillfulException("Service not found (id: " + id + ")");
        }

        ServiceDto serviceDto = ServiceMapper.map(optionalService.get());

        return ResponseEntity.ok(serviceDto);
    }

    @Override
    public ResponseEntity<ServiceDto> createService(String name) {
        if(name == null){
            throw new WillfulException("Service name is null");
        }
        com.denizozgun.hotel_booking_project.entity.Service saved =
                com.denizozgun.hotel_booking_project.entity.Service.builder().name(name).build();

        saved = serviceRepository.save(saved);
        return ResponseEntity.status(HttpStatus.CREATED).body(ServiceMapper.map(saved));
    }

    @Override
    public HttpStatus deleteServiceById(Long id) {
        getServiceById(id);

        serviceRepository.deleteById(id);
        return HttpStatus.NO_CONTENT;
    }
}
