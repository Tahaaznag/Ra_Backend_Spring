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
import { ForgetComponent } from './pages/forget/forget.component';
import { MessagingComponent } from './pages/messaging/messaging.component';
import { VideoCallComponent } from './pages/video-call/video-call.component';
import { ChatPageComponent } from './pages/chat-page/chat-page.component';

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
    ForgetComponent,
    MessagingComponent,
    VideoCallComponent,
    ChatPageComponent
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
