import {Component, OnInit} from '@angular/core';
import {error} from "@angular/compiler-cli/src/transformers/util";
import {Router} from "@angular/router";
import {KeycloakService} from "../../services/keycloak/keycloak.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit{
  email: string = "";
  passwordVisible: boolean = false;
  password: string = "";
  expertChecked: boolean = false;
  technicianChecked: boolean = false;

  ngOnInit(): void {
  }

  login() {
    console.log('Email : ', this.email);
    console.log('Mot de passe : ', this.password);
  }

  isFormValid() {
    return this.email !== '' && this.password !== '' && (this.expertChecked || this.technicianChecked);
  }

  togglePasswordVisibility() {
    this.passwordVisible = !this.passwordVisible;
    const input = document.getElementById('password');
    if (input) {
      input.setAttribute('type', this.passwordVisible ? 'text' : 'password');
    }
  }

  checkFormValidity() {

  }
}


