import {Component, ViewChild} from '@angular/core';

@Component({
  selector: 'app-technicien',
  templateUrl: './technicien.component.html',
  styleUrls: ['./technicien.component.scss']
})
export class TechnicienComponent {
  buttonsNav: any;
  showSearch: boolean = false;
  private notificationModal: any;
  private any: any;

  // @ts-ignore
  toggleSearch() {
    this.showSearch = !this.showSearch;
  }

  toggleNotification() {
    this.notificationModal.toggle();
  }

  toggleStar() {
    console.log("Star button clicked!");
  }
}
