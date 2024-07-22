import {Component, OnInit} from '@angular/core';
import {error} from "@angular/compiler-cli/src/transformers/util";
import {Router} from "@angular/router";
import {KeycloakService} from "../../services/keycloak/keycloak.service";
import {AuthService} from "../../services/Auth/auth.service";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit{
  email: string = "";
  passwordVisible: boolean = false;
  password: string = "";
  expertChecked: boolean = false;
  technicianChecked: boolean = false;
  errorMessage: string = "";

  constructor(private userService: AuthService, private router:Router , private http : HttpClient) {
  }
  ngOnInit(): void {
  }

  login() {
    if (!this.isFormValid()) {
      this.errorMessage = "Veuillez remplir tous les champs obligatoires.";
      return;
    }

    const loginRequest = { email: this.email, password: this.password };

    this.http.post(`http://localhost:8081/auth/authenticate`, loginRequest, {
      headers: { 'Content-Type': 'application/json' }
    })
      .subscribe(
        (response: any) => {
          console.log('Login successful');
          localStorage.setItem('token', response.token);
          this.router.navigate(['/dashboard']);
        },
        error => {
          console.error('Login failed', error);
          this.errorMessage = 'Email ou mot de passe incorrect';
        }
      );

  }

  isFormValid() {
    return this.email !== '' && this.password !== '';
  }

  togglePasswordVisibility() {
    this.passwordVisible = !this.passwordVisible;
    const input = document.getElementById('password');
    if (input) {
      input.setAttribute('type', this.passwordVisible ? 'text' : 'password');
    }
  }
}
