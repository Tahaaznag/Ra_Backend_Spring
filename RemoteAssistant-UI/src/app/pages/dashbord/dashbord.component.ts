import { Component } from '@angular/core';
import {RouterLink} from "@angular/router";

@Component({
  selector: 'app-dashbord',
  templateUrl: './dashbord.component.html',
  standalone: true,
  imports: [
    RouterLink
  ],
  styleUrls: ['./dashbord.component.scss']
})
export class DashbordComponent {

}
