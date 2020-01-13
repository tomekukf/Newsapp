import {Injectable} from '@angular/core';
import {HttpClient, HttpErrorResponse, HttpEvent, HttpHeaders, HttpResponse} from "@angular/common/http";
import {Observable, throwError} from "rxjs";
import {NewsContainer} from "../models/News";
import {environment} from "../../environments/environment";
import {catchError, tap} from "rxjs/operators";
import {ModalService} from "../_modal";

@Injectable({
  providedIn: 'root'
})
export class NewsService {
  baseApiUrl = environment.baseUrl;

  path = "news/pl/technology";
  testResponseWithError = "api";

  constructor(private http: HttpClient,private modalService: ModalService) {
  }


  getNews(): Observable<any> {
console.log(this.baseApiUrl+this.path);
    return this.http.get<any>(this.baseApiUrl+this.path).pipe(
      catchError(err => {
       return  this.handleError(err);
      })
    )
  }

  getNewsNotFOund() {
    return this.http.get(this.baseApiUrl+this.testResponseWithError)
      .pipe(catchError( (err ) => {
       return  this.handleError(err);
    }), tap(respData => {
      return this.handleData(respData)
    }));
  }


  private handleError(errorRes: HttpErrorResponse) {
    this.openModal('custom-error-modal');
    return throwError('Nie znaleziono danych')
  }

  private handleData(respData: Object) {
  }

  openModal(id: string) {
    this.modalService.open(id);
  }
}

