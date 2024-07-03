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
  date: string = '';

  constructor(private router: Router, private messageService: MessageService) {}

  joinChat() {
    if (this.username && this.date) {
      const randomId = this.generateRandomId();
      const users = JSON.parse(localStorage.getItem('users') || '[]');
      const firstChar = this.username.charAt(0).toUpperCase();
      localStorage.setItem('username', this.username);
      localStorage.setItem('userAvatar', firstChar);
      users.push({ username: this.username, date: this.date, id: randomId, status: 'online' });

      localStorage.setItem('users', JSON.stringify(users));
      this.router.navigate(['/chat', this.username, randomId]);
    }
  }

  generateRandomId(): string {
    return Math.random().toString(36).substring(2, 15);
  }
}
