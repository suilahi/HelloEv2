package org.helloevent.backend.Repositories;

import org.helloevent.backend.Entity.Client;
import org.helloevent.backend.Entity.Evenement;
import org.helloevent.backend.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EvenementRepository extends JpaRepository<Evenement, Integer> {
    List<Evenement> findByDate(String date);
}
