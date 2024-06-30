import { Component } from '@angular/core';
import { Role } from 'src/app/services/role.enum';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss']
})
export class SignupComponent {
  passwordVisible: boolean = false;
  email: string = "";
  password : string = ""
  name:string = "";
  prenom:string=""
  expertChecked: boolean = false;
  technicianChecked: boolean = false;
  role: Role | undefined;

  login() {

  }


  register() {

  }

  togglePasswordVisibility() {
    this.passwordVisible = !this.passwordVisible;
    const input = document.getElementById('password');
    if (input) {
      input.setAttribute('type', this.passwordVisible ? 'text' : 'password');
    }
  }

  isFormValid() {
    return this.email !== '' && this.password !== '' && (this.expertChecked || this.technicianChecked);
  }

}
