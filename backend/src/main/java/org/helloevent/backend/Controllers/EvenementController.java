package org.helloevent.backend.Controllers;

import jakarta.persistence.Id;
import org.helloevent.backend.Entity.Categorie;
import org.helloevent.backend.Entity.Evenement;
import org.helloevent.backend.Repositories.EvenementRepository;
import org.helloevent.backend.Services.EvenementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.ID;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/evenement")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*", allowCredentials = "true") // 👈 ici
public class EvenementController {

    private EvenementService evenementService;

    public EvenementController(EvenementService evenementService) {
        this.evenementService = evenementService;
    }

    @GetMapping("/get")
    public List<Evenement> getEvenements() {
        return evenementService.findAll();
    }

    @PostMapping("/create")

    public ResponseEntity<?> ajouter(@RequestBody Evenement evenement) {

        System.out.println(" Catégorie reçue : " + evenement.getCategorie());

        if (evenement.getCategorie() == null) {
            System.out.println(" Catégorie est nulle ");
            return ResponseEntity
                    .badRequest()
                    .body(" la catégorie est invalide . Valeurs possibles : " + Arrays.toString(Categorie.values()));
        }

        System.out.println("[INFO] Création de l'événement avec catégorie : " + evenement.getCategorie());
        Evenement savedEvent = evenementService.create(evenement);
        return ResponseEntity.ok(savedEvent);
    }

    @PutMapping("/put/{id}")
    public Evenement modification(@RequestBody Evenement evenement) {
        return evenementService.update(evenement);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEvenement(@PathVariable int id) {
        evenementService.delete(id);
    }

    @GetMapping("/serch/{date}")
    public List<Evenement> findByDate(@PathVariable String date) {
        return evenementService.findByDate(date);
    }
}
