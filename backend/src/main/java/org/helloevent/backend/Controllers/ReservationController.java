package org.helloevent.backend.Controllers;

import org.helloevent.backend.Entity.Reservation;
import org.helloevent.backend.Repositories.ReservationRepostory;
import org.helloevent.backend.Services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    private ReservationService reservationService;
    private ReservationRepostory reservationRepostory;

    @Autowired
    public ReservationController(ReservationService reservationService ,ReservationRepostory reservationRepostory) {
        this.reservationService = reservationService;
        this.reservationRepostory = reservationRepostory;
    }


    @PostMapping("/ajouter")
    public Reservation ajouterReservation(@RequestBody Reservation reservation) {
        return reservationService.ajouterReservation(reservation);
    }
    @GetMapping("/getAll")
    public List<Reservation> getAllReservations() {
        return reservationService.findAll();
    }


}
