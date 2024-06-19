import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {connect} from "rxjs";
import {WebsocketService} from "../../services/WebSocket/web-socket.service";

@Component({
  selector: 'app-messaging',
  templateUrl: './messaging.component.html',
  styleUrls: ['./messaging.component.scss']
})
export class MessagingComponent{

  username: string = '';
  message: string = '';
  messages: any[] = [];

  constructor(private websocketService: WebsocketService) { }

  ngOnInit() {
    // Initialisation de la connexion WebSocket
    this.username = '';
  }

  connect() {
    if (this.username) {
      this.websocketService.connect(this.username);
    }
  }

  sendMessage() {
    if (this.message) {
      this.websocketService.sendMessage(this.message);
      this.message = '';
    }
  }

  getAvatarColor(messageSender: string) {
    // Fonction pour générer une couleur d'avatar
    const hash = messageSender.split('').reduce((acc, char) => {
      acc = ((acc << 5) - acc) + char.charCodeAt(0);
      return acc & acc;
    }, 0);
    const index = Math.abs(hash % 8);
    const colors = [
      '#2196F3', '#32c787', '#00BCD4', '#ff5652',
      '#ffc107', '#ff85af', '#FF9800', '#39bbb0'
    ];
    return colors[index];
  }
}
