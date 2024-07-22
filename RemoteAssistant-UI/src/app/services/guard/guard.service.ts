import { Injectable } from '@angular/core';
import { CanActivate, CanDeactivate } from '@angular/router';
import {LoadingService} from "../Loading/loading.service";

@Injectable({
  providedIn: 'root'
})
export class LoadingGuard implements CanActivate, CanDeactivate<any> {

  constructor(private loadingService: LoadingService) { }

  canActivate(): boolean {
    this.loadingService.show();
    setTimeout(() => this.loadingService.hide(), 1000); // Cache le spinner après 1 seconde (ajustez le délai selon les besoins)
    return true;
  }

  canDeactivate(): boolean {
    this.loadingService.hide();
    return true;
  }
}
