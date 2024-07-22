import { Component, OnInit } from '@angular/core';
import { ChatMessage } from "../../models/chat-message";
import { ActivatedRoute } from "@angular/router";
import {MessageService} from "../../services/message.service";

@Component({
  selector: 'app-message',
  templateUrl: './message.component.html',
  styleUrls: ['./message.component.scss']
})
export class MessageComponent implements OnInit {
  messageInput: string = '';
  userId: string = '';
  messageList: any[] = [];

  constructor(private messageService: MessageService, private route: ActivatedRoute) {}

  ngOnInit() {
    this.userId = this.route.snapshot.params["userId"];
    this.messageService.joinRoom("ABC");
    this.listenerMessage();
  }

  sendMessage() {
    const chatMessage = {
      message: this.messageInput,
      user: this.userId
    } as ChatMessage;
    this.messageService.sendMessage("ABC", chatMessage);
    this.messageInput = '';
  }

  listenerMessage() {
    this.messageService.getMessageSubject().subscribe((messages: ChatMessage[]) => {
      this.messageList = messages.map((item: ChatMessage) => ({
        ...item,
        message_side: item.user === this.userId ? 'sender' : 'receiver'
      }));
    });
  }
}
