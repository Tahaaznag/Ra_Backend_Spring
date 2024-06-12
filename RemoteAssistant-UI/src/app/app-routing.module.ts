import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {LoginComponent} from "./pages/login/login.component";
import {TechnicienComponent} from "./pages/technicien/technicien.component";
import {ExpertComponent} from "./pages/expert/expert.component";
import {HomeComponent} from "./pages/home/home.component";
import {SignupComponent} from "./pages/signup/signup.component";
import {ForgetComponent} from "./pages/forget/forget.component";
import {MessagingComponent} from "./pages/messaging/messaging.component";
import {VideoCallComponent} from "./pages/video-call/video-call.component";

const routes: Routes = [
  {
    path : "login" ,
    component : LoginComponent
  },
  {
    path : "technicien",
    component: TechnicienComponent
  },
  {
    path: "expert",
    component:ExpertComponent
  },
  {
    path : '',
    component:HomeComponent
  },
  {
    path: "signup",
    component:SignupComponent
  },
  {
    path:"forgot-password",
    component:ForgetComponent
  },
  {
    path:"messaging",
    component:MessagingComponent
  },
  {
    path:"video-call",
    component:VideoCallComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
