package com.orbitelco.inventory.data.repository;

import com.orbitelco.inventory.data.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import java.sql.Date;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
  List<Reservation> findAllByReservationDate(Date date);
}
