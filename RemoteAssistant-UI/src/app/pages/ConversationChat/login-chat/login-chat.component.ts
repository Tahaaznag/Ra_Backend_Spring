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
    if (this.username.trim()) {
      let sessionDto = {
        sessionName: this.username
      };

      this.sessionService.createSession(sessionDto).subscribe(
        (response) => {
          this.router.navigate(['/chat', this.username]);
        },
        (error) => {
          console.error('Erreur lors de la création de la session :', error);
        }
      );
    } else {
      console.error('Le nom d\'utilisateur est requis.');
    }
  }
}
