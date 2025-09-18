package com.denizozgun.hotel_booking_project.repository;

import com.denizozgun.hotel_booking_project.entity.Reservation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long>, PagingAndSortingRepository<Reservation, Long> {

    Page<Reservation> findAllByUserId(long userId, Pageable pageable);

    List<Reservation> findAllByUser_IdAndRoom_Hotel_Id(long userId, long hotelId);

    Reservation findByDateAndRoomId(LocalDate date, Long roomId);


}
