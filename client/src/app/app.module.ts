import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NewscontainerComponent } from './newscontainer/newscontainer.component';
import { NewsitemComponent } from './newsitem/newsitem.component';
import {ModalModule} from "./_modal";
import {FormsModule} from "@angular/forms";

@NgModule({
  declarations: [
    AppComponent,
    NewscontainerComponent,
    NewsitemComponent
  ],
  imports: [
    FormsModule,
    ModalModule,
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
