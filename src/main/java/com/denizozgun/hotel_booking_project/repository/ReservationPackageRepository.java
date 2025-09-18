package com.denizozgun.hotel_booking_project.repository;

import com.denizozgun.hotel_booking_project.entity.ReservationPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationPackageRepository extends JpaRepository<ReservationPackage, Long> {
}
