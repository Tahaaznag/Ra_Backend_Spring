import {Component, OnInit} from '@angular/core';
import {MessageService} from "../../services/message.service";
import {ChatMessage} from "../../models/chat-message";

@Component({
  selector: 'app-message',
  templateUrl: './message.component.html',
  styleUrls: ['./message.component.scss']
})
export class MessageComponent implements OnInit{
constructor(private messageService : MessageService) {

  }

  ngOnInit() {
    this.messageService.joinRoom("ABC");
  }

  sendMessage(){
  const chatMessage = {
    message : 'bonjour',
    user:'1'
  }as ChatMessage
  this.messageService.sendMessage("ABC",chatMessage);
  }
}
