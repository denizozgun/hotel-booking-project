package com.denizozgun.hotel_booking_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.denizozgun.hotel_booking_project.entity.Service;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Long> {
}
