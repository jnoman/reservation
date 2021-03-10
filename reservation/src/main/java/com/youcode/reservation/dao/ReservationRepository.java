package com.youcode.reservation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.youcode.reservation.beans.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
