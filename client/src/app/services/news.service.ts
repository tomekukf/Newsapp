import {Injectable} from '@angular/core';
import {HttpClient, HttpErrorResponse, HttpEvent, HttpHeaders, HttpResponse} from "@angular/common/http";
import {Observable, throwError} from "rxjs";
import {NewsContainer} from "../models/News";
import {environment} from "../../environments/environment";
import {catchError, tap} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class NewsService {
  baseApiUrl = environment.baseUrl;

  path = "news/pl/technology";
  api2 = "http://localhost:8080/api";

  constructor(private http: HttpClient) {
  }

  httpOptions = {
    headers: new HttpHeaders({
      'Access-Control-Allow-Origin': '*',
    })
  };

  getNews(): Observable<any> {
console.log(this.baseApiUrl+this.path);
    return this.http.get<any>(this.baseApiUrl+this.path).pipe(
      catchError(err => {
       return  this.handleError(err);
      })
    )
  }


  getNewsNotFOund() {

    return this.http.get(this.api2)
      .pipe(catchError( (err ) => {
       return  this.handleError(err);
    }), tap(respData => {
      return this.handleData(respData)
    }));
  }


  private handleError(errorRes: HttpErrorResponse) {
    console.log(errorRes)
    return throwError('Nie znaleziono danych')
  }

  private handleData(respData: Object) {


  }
}

