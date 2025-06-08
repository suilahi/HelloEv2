import { Component } from '@angular/core';
import {FormBuilder, FormGroup, ReactiveFormsModule, Validators} from '@angular/forms';
import {Evenement, EvenementService} from '../../../Service/evenement.service';
import {CommonModule} from '@angular/common';

@Component({
  selector: 'app-add-event',
  templateUrl: './add-event.component.html',
  imports: [
    CommonModule,
    ReactiveFormsModule
  ],

  standalone: true,
  styleUrls: ['./add-event.component.scss']
})
export class AddEventComponent {
  eventForm: FormGroup;

  constructor(
    private fb: FormBuilder,
    private evenementService: EvenementService
  ) {
    this.eventForm = this.fb.group({
      titre: ['', Validators.required],
      date: ['', Validators.required],
      lieu: ['', Validators.required],
      description: [''],
      categorie: ['', Validators.required],
    });

  }

  onSubmit(): void {
    if (this.eventForm.valid) {
      const newEvent: Evenement = this.eventForm.value;
      this.evenementService.createEvenement(newEvent).subscribe({
        next: () => {
          alert('Événement ajouté avec succès !');
          this.eventForm.reset();
        },
        error: (err) => console.error('Erreur lors de l’ajout :', err)
      });
    }
  }
}
