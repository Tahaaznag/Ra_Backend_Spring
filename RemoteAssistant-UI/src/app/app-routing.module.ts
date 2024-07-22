import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {LoginComponent} from "./pages/login/login.component";
import {TechnicienComponent} from "./pages/technicien/technicien.component";
import {ExpertComponent} from "./pages/expert/expert.component";
import {HomeComponent} from "./pages/home/home.component";
import {SignupComponent} from "./pages/signup/signup.component";
import {MessageComponent} from "./pages/message/message.component";
import {LoginChatComponent} from "./pages/ConversationChat/login-chat/login-chat.component";
import {DashboardComponent} from "./dashboard/dashboard.component";
import {LoadingGuard} from "./services/guard/guard.service";

const routes: Routes = [
  {
    path : "login" ,
    component : LoginComponent,
    canActivate: [LoadingGuard]
  },
  {
    path : "technicien",
    component: TechnicienComponent,
    canActivate: [LoadingGuard]
  },
  {
    path: "expert",
    component:ExpertComponent,
    canActivate: [LoadingGuard]
  },
  {
    path : '',
    component:HomeComponent,
    canActivate: [LoadingGuard]
  },
  {
    path: "signup",
    component:SignupComponent,
    canActivate: [LoadingGuard]
  },
  {
    path:"chat/:username",
    component:MessageComponent,
    canActivate: [LoadingGuard]
  },
  {
    path:'loginChat',
    component:LoginChatComponent,
    canActivate: [LoadingGuard]
  },
  {
    path:'dashboard',
    component:DashboardComponent,
    canActivate: [LoadingGuard]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
