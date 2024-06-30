import {Component, ViewChild} from '@angular/core';

@Component({
  selector: 'app-technicien',
  templateUrl: './technicien.component.html',
  styleUrls: ['./technicien.component.scss']
})
export class TechnicienComponent{

  users: { username: string, id: string, status: string }[] = [];

  constructor() {
    const users = localStorage.getItem('users');
    if (users) {
      this.users = JSON.parse(users);
    }
  }

  toggleStatus(index: number) {
    this.users[index].status = this.users[index].status === 'online' ? 'offline' : 'online';
    localStorage.setItem('users', JSON.stringify(this.users));
  }
}
