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

export function KcFactory(KcService : KeycloakService){
  return () => KcService.init();
}


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    TechnicienComponent,
    ExpertComponent,
    SignupComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule,
  ],
  providers: [
    HttpClient,
   /* {
      provide: APP_INITIALIZER,
      deps:[KeycloakService],
      useFactory: KcFactory,
      multi: true
    }*/
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
