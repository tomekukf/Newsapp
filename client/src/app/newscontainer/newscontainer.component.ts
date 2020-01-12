import { Component, OnInit } from '@angular/core';
import {NewsService} from "../services/news.service";
import {News, NewsContainer} from "../models/News";

@Component({
  selector: 'app-news-container',
  templateUrl: './newscontainer.component.html',
  styleUrls: ['./newscontainer.component.scss']
})
export class NewscontainerComponent implements OnInit {

  title = "Przegladarka newsów";
  newsContiner: NewsContainer;
  articles;
  country: string;

  constructor(private newsService: NewsService) {
  }

  ngOnInit() {
    this.newsService.getNews().subscribe(data => {
      this.newsContiner = data;
      console.log(this.newsContiner)
      this.articles=data.articles;
    });
    // this.newsService.getNewsNotFOund().subscribe(d=>{
    //   console.log(d)
    // });
  }

}
