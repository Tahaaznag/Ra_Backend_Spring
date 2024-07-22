import { Component } from '@angular/core';
import {NgxSpinnerService} from "ngx-spinner";
import {LoadingService} from "./services/Loading/loading.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'RemoteAssistant-UI';


  constructor(public loadingService : LoadingService) {}
}
