import {APP_INITIALIZER, NgModule} from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {KeycloakService} from "./services/keycloak/keycloak.service";
import { LoginComponent } from './pages/login/login.component';
import {FormsModule} from "@angular/forms";
import {HttpClient, HttpClientModule} from "@angular/common/http";
import { TechnicienComponent } from './pages/technicien/technicien.component';
import { ExpertComponent } from './pages/expert/expert.component';
import { SignupComponent } from './pages/signup/signup.component';
import { HomeComponent } from './pages/home/home.component';
import { NavbarComponent } from './pages/navbar/navbar.component';
import { FooterComponent } from './pages/footer/footer.component';
import { MessageComponent } from './pages/message/message.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {NgxSpinnerComponent, NgxSpinnerModule} from "ngx-spinner";

export function KcFactory(KcService : KeycloakService){
  return () => KcService.init();
}


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    TechnicienComponent,
    ExpertComponent,
    SignupComponent,
    HomeComponent,
    NavbarComponent,
    FooterComponent,
    MessageComponent,
    DashboardComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    NgxSpinnerComponent,
    NgxSpinnerModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
