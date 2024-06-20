import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {LoginComponent} from "./pages/login/login.component";
import {TechnicienComponent} from "./pages/technicien/technicien.component";
import {ExpertComponent} from "./pages/expert/expert.component";
import {HomeComponent} from "./pages/home/home.component";
import {SignupComponent} from "./pages/signup/signup.component";
import {MessageComponent} from "./pages/message/message.component";
import {LoginChatComponent} from "./pages/ConversationChat/login-chat/login-chat.component";
import {DashbordComponent} from "./pages/dashbord/dashbord.component";

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
    path:"chat/:userId",
    component:MessageComponent
  },
  {
    path:'loginChat',
    component:LoginChatComponent
  },
  {
    path:'dashbord',
    component:DashbordComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
