import { Component, OnInit } from '@angular/core';
import {News} from "../models/News";

@Component({
  selector: 'app-newsitem',
  templateUrl: './newsitem.component.html',
  styleUrls: ['./newsitem.component.scss'],
  inputs: ['newsitem'],
})
export class NewsitemComponent implements OnInit {

  newsitem: News;

  constructor() { }

  ngOnInit() {
  }

}
