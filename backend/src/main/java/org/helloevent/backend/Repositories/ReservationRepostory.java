package org.helloevent.backend.Repositories;

import org.helloevent.backend.Entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReservationRepostory extends JpaRepository<Reservation,Long> {
}
