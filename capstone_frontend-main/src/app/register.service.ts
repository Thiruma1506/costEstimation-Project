import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {
  private baseUrl = 'http://localhost:9091/users/register'; // Adjust if needed

  constructor(private http: HttpClient) {}

  // Register User
  register(credentials: { username: string; email: string; password: string }): Observable<any> {
    return this.http.post(this.baseUrl, credentials);
  }
}
