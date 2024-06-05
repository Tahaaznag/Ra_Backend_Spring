import { Component } from '@angular/core';

@Component({
  selector: 'app-expert',
  templateUrl: './expert.component.html',
  styleUrls: ['./expert.component.scss']
})
export class ExpertComponent {
  showSearch: boolean = false;
  private notificationModal: any;
  showNotification:  boolean = false;
  showMonEspace:boolean=false
  showSidebar:boolean=false


  toggleSearch() {
    this.showSearch = !this.showSearch;
  }
  toggleNotification() {
    this.showNotification = !this.showNotification;
  }

  toggleStar() {
    console.log("Star button clicked!");
  }
  toggleMonEspace(event: Event) {
    event.preventDefault();
    this.showMonEspace = !this.showMonEspace;
  }
  toggleSidebar() {
    this.showSidebar = !this.showSidebar;
  }
}
