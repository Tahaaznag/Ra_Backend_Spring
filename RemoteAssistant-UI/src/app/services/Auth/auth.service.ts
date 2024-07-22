import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private api = 'http://localhost:8081/auth/register';
  constructor(private http : HttpClient) { }

  register(user: any): Observable<any> {
    return this.http.post<any>(this.api, user);
  }
}
