import { Component } from '@angular/core';
import {Router} from "@angular/router";
import {MessageService} from "../../../services/message.service";
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
  id: string = '';

  constructor(private router: Router, private messageService: MessageService) {}

  joinChat() {
    if (this.username) {
      const randomId = this.generateRandomId();
      const users = JSON.parse(localStorage.getItem('users') || '[]');

      users.push({ username: this.username, id: randomId, status: 'online' });

      localStorage.setItem('users', JSON.stringify(users));
      this.router.navigate(['/chat', this.username, randomId]);
    }
  }

  generateRandomId(): string {
    return Math.random().toString(36).substring(2, 15);
  }
}
