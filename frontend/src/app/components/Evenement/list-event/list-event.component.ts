import { Component, OnInit } from '@angular/core';
import {Evenement, EvenementService} from '../../../Service/evenement.service';
import {CommonModule} from '@angular/common';

@Component({
  selector: 'app-list-event',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './list-event.component.html',
})
export class ListEventComponent implements OnInit {
  evenements: Evenement[] = [];
  isLoading = true;

  constructor(private evenementService: EvenementService) {}

  ngOnInit(): void {
    this.evenementService.getAllEvenements().subscribe({
      next: (data) => {
        this.evenements = data;
        this.isLoading = false;
      },
      error: (err) => {
        console.error('Erreur lors du chargement des événements :', err);
        this.isLoading = false;
      }
    });
  }
}
