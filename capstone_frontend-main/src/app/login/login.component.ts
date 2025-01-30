import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router, RouterModule } from '@angular/router'; // ✅ Import RouterModule
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-login',
  standalone: true,
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  imports: [CommonModule, ReactiveFormsModule, FormsModule, RouterModule], // ✅ Ensure RouterModule is imported
})
export class LoginComponent {
  loginForm: FormGroup;
  loginError: string = '';

  constructor(private fb: FormBuilder, private authService: AuthService, private router: Router) {
    this.loginForm = this.fb.group({
      role: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]], // Change from username to email
      password: ['', Validators.required],
    });
  }

  onLogin() {
    if (this.loginForm.valid) {
      const { role, email, password } = this.loginForm.value; // Using email instead of username
      this.authService.loginUser({ role, email, password }).subscribe({
        next: (response) => {
          this.authService.storeToken(response.token);
          this.router.navigate(['/user-home']);
        },
        error: () => {
          this.loginError = 'Invalid email or password';
        },
      });
    }
  }
}
