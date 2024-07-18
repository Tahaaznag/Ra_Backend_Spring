import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { SessionService } from '../../../services/session.service';
import {FormsModule} from "@angular/forms";

@Component({
  selector: 'app-login-chat',
  templateUrl: './login-chat.component.html',
  standalone: true,
  imports: [
    FormsModule
  ],
  styleUrls: ['./login-chat.component.scss']
})
export class LoginChatComponent {
  username: string = '';

  constructor(private router: Router, private sessionService: SessionService) {}

  joinChat() {
    if (this.username.trim()) { // Vérifie que le nom d'utilisateur n'est pas vide
      let sessionDto = {
        sessionName: this.username // Utilisez le nom d'utilisateur comme nom de session
      };

      this.sessionService.createSession(sessionDto).subscribe(
        (response) => {
          this.router.navigate(['/chat', this.username]); // Redirige vers la page de chat avec le nom d'utilisateur
        },
        (error) => {
          console.error('Erreur lors de la création de la session :', error);
          // Gérer l'erreur de création de session
        }
      );
    } else {
      console.error('Le nom d\'utilisateur est requis.');
      // Gérer l'erreur de validation du nom d'utilisateur
    }
  }
}
