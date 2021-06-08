import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({providedIn: 'root'})
export class OrdersService {
  public API = '//localhost:8080';
  public ORDERS_ROOT = this.API + '/order';
  //private allOrdersUrl = this.API + '/all'

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<any> {
    return this.http.get(this.ORDERS_ROOT);
  }

  get(id: string) {
    return this.http.get(this.ORDERS_ROOT + '/' + id);
  }

  save(orders: any): Observable<any> {
    let result: Observable<Object>;
    if (orders['href']) {
      result = this.http.put(this.ORDERS_ROOT, orders);
    } else {
      result = this.http.post(this.ORDERS_ROOT, orders);
    }
    return result;
  }

  
  remove(href: string) {
    // let httpParams = new HttpParams().set('aaa', '111');
    // httpParams.set('bbb', '222');

    // let options = { params: httpParams };
    return this.http.delete(href);
  }
}
