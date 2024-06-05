import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {LoginComponent} from "./pages/login/login.component";
import {TechnicienComponent} from "./pages/technicien/technicien.component";
import {ExpertComponent} from "./pages/expert/expert.component";

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
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
