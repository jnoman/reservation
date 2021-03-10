package com.youcode.reservation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.youcode.reservation.beans.Reserver;

public interface ReserverRepository extends JpaRepository<Reserver, Long> {

}
