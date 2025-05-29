// src/app/components/home/home.component.ts
import { Component, OnInit } from '@angular/core';
import { EvenementService, Evenement } from '../../Service/evenement.service';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule, HttpClientModule],
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  evenements: Evenement[] = [];

  constructor(private evenementService: EvenementService) {}

  ngOnInit(): void {
    this.evenementService.getAllEvenements().subscribe({
      next: (data) => this.evenements = data,
      error: (err) => console.error('Erreur lors de la récupération', err)
    });
  }
}
