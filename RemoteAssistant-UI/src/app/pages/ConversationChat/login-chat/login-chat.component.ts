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

  constructor(private router: Router, private messageService: MessageService) {}

  joinChat() {
    if (this.username) {
      this.router.navigate(['/chat', this.username]);
    }
  }
}
