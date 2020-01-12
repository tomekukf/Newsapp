import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {NewscontainerComponent} from "./newscontainer/newscontainer.component";

const routes: Routes = [
  {
    component: NewscontainerComponent,
    path: ''
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
