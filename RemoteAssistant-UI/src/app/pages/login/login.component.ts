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


  ngOnInit(): void {
  }


 /* email: string = '';
  password: string = '';
  errorMsg: Array<string> = [];


  constructor(private router:Router , private keycloakService : KeycloakService) {

  }


  login() {
    this.errorMsg = [];
    this.authService.authenticate({
      body:this.authRequest
    }).subscribe({
      next : (res) =>{
        this.tokenService.token = res.token as string;
        this.router.navigate(['']);
      },
      error:(err) =>{
        console.log(err);
        if (err.error.validationErros){
          this.errorMsg = err.error.validationErros;
        }else {
          this.errorMsg.push(err.error.errorMsg);
        }
      }
    })
  }

  register() {
    this.router.navigate(['register'])
  }

  async ngOnInit(): Promise<void> {
    await this.keycloakService.init();
    await this.keycloakService.login();
  }*/
  password: string = "";
  login() {
    console.log('Email : ', this.email);
    console.log('Mot de passe : ', this.password);
  }

  isFormValid() {
    console.log("test1");
    return this.email !== '' && this.password !== '';
  }

  togglePasswordVisibility() {
    this.passwordVisible = !this.passwordVisible;
    const input = document.getElementById('password');
    if (input) {
      input.setAttribute('type', this.passwordVisible ? 'text' : 'password');
    }
  }
}


