import { Injectable } from '@angular/core';
import {Router} from "@angular/router";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  public users: any = {
    admin: { password: 'root', roles: ['EXPERT', 'ADMIN'] },
    technicien: { password: 'root', roles: ['TECHNICIEN'] }
  };

  public email: any;
  public isAuthenticated : boolean= false;
  public roles : string[] = [];


  constructor(private route :Router) { }

  public login(email: string, password: string): boolean {
    if (this.users[email] && this.users[email].password === password) {
      this.email=email;
      this.isAuthenticated=true;
      this.roles = this.users[email]['roles'];
      return true;
    }
    return false;
  }

  logout() {
    this.isAuthenticated=false;
    this.roles=[];
    this.email=undefined;
    this.route.navigateByUrl("/login")
  }
}
