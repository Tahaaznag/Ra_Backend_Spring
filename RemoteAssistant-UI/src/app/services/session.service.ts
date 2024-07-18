import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SessionService {

  private baseURL = 'http://localhost:8081/api/session';

  constructor(private http: HttpClient) { }

  createSession(sessionDto: any): Observable<any> {
    return this.http.post<any>(`${this.baseURL}/create`, sessionDto);
  }
}
