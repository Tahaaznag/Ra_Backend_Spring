import { Component } from '@angular/core';

@Component({
  selector: 'app-forget',
  templateUrl: './forget.component.html',
  styleUrls: ['./forget.component.scss']
})
export class ForgetComponent {
  email: string = "";

  login() {

  }

  checkFormValidity() {

  }

  isFormValid() {
    return this.email !== '';
  }
}
