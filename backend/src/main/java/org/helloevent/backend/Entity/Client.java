package org.helloevent.backend.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Client extends User{

    @OneToMany(mappedBy = "client")
    @JsonBackReference

    private List<Reservation> reservations;

}
