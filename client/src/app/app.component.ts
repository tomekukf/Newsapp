import { Component } from '@angular/core';
import {NewsContainer} from "./models/News";
import {NewsService} from "./services/news.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'Przegladarka newsów';
  newsContiner: NewsContainer;


  constructor(private newsService: NewsService) {
  }

}
