import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NewscontainerComponent } from './newscontainer/newscontainer.component';
import { NewsitemComponent } from './newsitem/newsitem.component';

@NgModule({
  declarations: [
    AppComponent,
    NewscontainerComponent,
    NewsitemComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
