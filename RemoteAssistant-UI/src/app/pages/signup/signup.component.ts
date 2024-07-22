import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../../services/Auth/auth.service';
import { Role } from 'src/app/services/role.enum';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss']
})
export class SignupComponent {
  passwordVisible: boolean = false;
  email: string = "";
  password: string = "";
  name: string = "";
  prenom: string = "";
  role: Role | undefined;

  constructor(private userService: AuthService, private router: Router) { }

  register() {
    if (this.password.length < 8) {
      alert('Le mot de passe doit contenir au moins 8 caractères.');
      return;
    }

    if (this.isFormValid()) {
      const user = {
        name: this.name,
        prenom: this.prenom,
        email: this.email,
        password: this.password,
        role: this.role
      };

      this.userService.register(user).subscribe({
        next: (response) => {
          console.log('Compte créé avec succès', response);
          this.router.navigate(['/dashboard']);
        },
        error: (error) => {
          console.error('Erreur lors de la création du compte', error);
          alert('Erreur lors de la création du compte. Veuillez réessayer.');
        }
      });
    } else {
      alert('Veuillez remplir tous les champs obligatoires.');
    }
  }

  togglePasswordVisibility() {
    this.passwordVisible = !this.passwordVisible;
    const input = document.getElementById('password');
    if (input) {
      input.setAttribute('type', this.passwordVisible ? 'text' : 'password');
    }
  }

  isFormValid() {
    return this.email && this.password && this.role !== undefined && this.name && this.prenom;
  }
}
