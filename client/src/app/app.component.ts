import {Component} from '@angular/core';
import {NewsContainer} from "./models/News";
import {ModalService} from "./_modal";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
})
export class AppComponent {
  title = 'Przegladarka newsów';
  newsContiner: NewsContainer;

  constructor(private modalService: ModalService) { }

  closeModal(id: string) {
    this.modalService.close(id);
  }
}
