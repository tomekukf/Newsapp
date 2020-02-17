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
  articles: News[];
  country: string;

  constructor(private newsService: NewsService) {
  }

  ngOnInit() {
    this.newsService.getNews().subscribe((data) => {
      // let newsContainerHttpResponse = data.clone();
      // newsContainerHttpResponse.body
      // @ts-ignore
      console.log(data.articles )
      // @ts-ignore
      this.articles=data.articles;
    });

    //Test -  Not_Found 404
    // this.newsService.getNewsNotFOund().subscribe(d=>{
    //   console.log(d)
    // });



    // this.articles = [
    //   {
    //     author: "tomek",
    //     title: "test",
    //     description: "test",
    //     date: "123",
    //     sourceName: "123  ",
    //     articleUrl: "123",
    //     imageUrl: "123"
    //   },
    //   {
    //     author: "tomek",
    //     title: "test",
    //     description: "test",
    //     date: "123",
    //     sourceName: "123  ",
    //     articleUrl: "123",
    //     imageUrl: "123"
    //   },
    //   {
    //     author: "tomek",
    //     title: "test",
    //     description: "test",
    //     date: "123",
    //     sourceName: "123  ",
    //     articleUrl: "123",
    //     imageUrl: "123"
    //   },
    //   {
    //     author: "tomek",
    //     title: "test",
    //     description: "test",
    //     date: "123",
    //     sourceName: "123  ",
    //     articleUrl: "123",
    //     imageUrl: "123"
    //   }
    // ]
  }

}
// author: string;
// title: string;
// description: string;
// date: string;
// sourceName: string;
// articleUrl: string;
// imageUrl: string;
