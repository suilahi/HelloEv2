import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {FormGroup} from '@angular/forms';

export interface RegisterRequest {
  name: string;
  email: string;
  password: string;
  role: string;
}


@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private baseUrl = 'http://localhost:8080/auth';

  constructor(private http: HttpClient) {}

  register(request: RegisterRequest): Observable<any> {
    return this.http.post(`${this.baseUrl}/register`, request);
  }

  login(credentials: {email: string, password: string}): Observable<any> {
    return this.http.post(`${this.baseUrl}/login`, credentials);
  }
}
