import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  private apiUrl = 'http://localhost:9091/users'; // Adjust as needed

  constructor(private http: HttpClient) {}

  // This method checks if a valid token exists in localStorage to determine if the user is authenticated
  isAuthenticated(): boolean {
    return !!this.getToken(); // Returns true if token exists, false otherwise
  }

  // Registration API
  registerUser(userData: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/register`, userData, {
      responseType: 'text', // Backend returns plain text message
    });
  }

  // Login API
  loginUser(credentials: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/login`, credentials);
  }

  // Store JWT Token in localStorage
  storeToken(token: string): void {
    localStorage.setItem('authToken', token);
  }

  // Retrieve JWT Token from localStorage
  getToken(): string | null {
    return localStorage.getItem('authToken');
  }

  // Check if the user is logged in based on token existence
  isLoggedIn(): boolean {
    return !!this.getToken();
  }

  // Log out the user and remove the token from localStorage
  logout(): void {
    localStorage.removeItem('authToken');
  }
}
