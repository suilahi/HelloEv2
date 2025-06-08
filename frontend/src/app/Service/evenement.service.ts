import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Evenement {
  id?: number;
  titre: string;
  date: string;
  lieu: string;
  description: string;
  categorie: string;
}

@Injectable({
  providedIn: 'root'
})
export class EvenementService {
  private apiUrl = 'http://localhost:8080/evenement';

  constructor(private http: HttpClient) {}


  getAllEvenements(): Observable<Evenement[]> {
    return this.http.get<Evenement[]>(`${this.apiUrl}/get`);
  }

  createEvenement(event: Evenement): Observable<Evenement> {
    return this.http.post<Evenement>(`${this.apiUrl}/create`, event);
  }
}
