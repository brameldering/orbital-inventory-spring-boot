package com.orbitelco.inventory.data.repository;

import com.orbitelco.inventory.data.entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest, Long> {

}
