import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PortfolioService {
  public API = '//localhost:8080';
  public PORTFOLIO_API = this.API + '/portfolio';

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<any> {
    return this.http.get(this.API + '/portfolio');
  }

  get(id: string) {
    return this.http.get(this.PORTFOLIO_API + '/' + id);
  }

  save(portfolio: any): Observable<any> {
    let result: Observable<Object>;
    if (portfolio['href']) {
      result = this.http.put(this.PORTFOLIO_API, portfolio);
    } else {
      result = this.http.post(this.PORTFOLIO_API, portfolio);
    }
    return result;
  }

  remove(href: string) {
    return this.http.delete(href);
  }
}
