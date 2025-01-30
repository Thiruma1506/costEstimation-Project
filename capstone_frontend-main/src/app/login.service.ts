import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, BehaviorSubject } from 'rxjs';
import { map } from 'rxjs/operators';
import { JwtPayload, jwtDecode } from 'jwt-decode';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private baseUrl = 'http://localhost:9091/users/login'; // Adjust if needed
  private authStatus = new BehaviorSubject<boolean>(this.hasToken());

  constructor(private http: HttpClient) {}

  // Login User
  loginUser(credentials: { email: string; password: string; role: string }): Observable<any> {
    return this.http.post(this.baseUrl, credentials).pipe(
      map((response: any) => {
        if (response.token) { // Ensure the backend sends 'token' not 'jwt'
          localStorage.setItem('token', response.token);
          this.authStatus.next(true);
        }
        return response;
      })
    );
  }

  // Logout
  logout(): void {
    localStorage.removeItem('token');
    this.authStatus.next(false);
  }

  // Check Authentication Status
  isAuthenticated(): boolean {
    return !!this.getToken();
  }

  // Get Stored JWT Token
  getToken(): string | null {
    return localStorage.getItem('token');
  }

  // Get User Role from JWT
  getUserRole(): string | null {
    const token = this.getToken();
    if (token) {
      const decoded: any = jwtDecode<{ role: string }>(token);
      return decoded.role;
    }
    return null;
  }

  // Observable for Auth Status
  getAuthStatus(): Observable<boolean> {
    return this.authStatus.asObservable();
  }

  // Check if Token Exists
  private hasToken(): boolean {
    return !!localStorage.getItem('token');
  }
}
