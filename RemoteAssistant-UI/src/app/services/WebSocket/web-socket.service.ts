import { Injectable } from '@angular/core';
import * as Stomp from 'stompjs';
import * as SockJS from 'sockjs-client';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class WebsocketService {
  private stompClient!: Stomp.Client;
  private messageSubject: BehaviorSubject<any>;

  constructor() {
    this.messageSubject = new BehaviorSubject(null);
  }

  public connect(username: string) {
    const socket = new SockJS('http://localhost:8081/ws');
    this.stompClient = Stomp.over(socket);
    this.stompClient.connect({}, () => {
      this.stompClient.subscribe('/topic/public', (payload) => {
        this.messageSubject.next(JSON.parse(payload.body));
      });
      // Tell the server that this user has joined
      this.sendUsername(username);
    });
  }

  public sendMessage(message: string) {
    if (this.stompClient) {
      const chatMessage = {
        sender: localStorage.getItem('username'),
        content: message,
        type: 'CHAT'
      };
      this.stompClient.send('/app/chat.sendMessage', {}, JSON.stringify(chatMessage));
    }
  }

  public getMessages() {
    return this.messageSubject.asObservable();
  }

  private sendUsername(username: string) {
    localStorage.setItem('username', username);
    const chatMessage = {
      sender: username,
      type: 'JOIN'
    };
    this.stompClient.send('/app/chat.addUser', {}, JSON.stringify(chatMessage));
  }
}
