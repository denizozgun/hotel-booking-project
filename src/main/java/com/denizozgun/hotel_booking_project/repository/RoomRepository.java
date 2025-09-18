package com.denizozgun.hotel_booking_project.repository;


import com.denizozgun.hotel_booking_project.entity.Hotel;
import com.denizozgun.hotel_booking_project.entity.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long>, JpaSpecificationExecutor<Room>,
        PagingAndSortingRepository<Room, Long> {

    Page<Room> findAllByHotel(Hotel hotel, Pageable pageable);
}
