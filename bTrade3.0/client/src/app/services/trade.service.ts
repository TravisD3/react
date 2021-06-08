import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Trade, Account, OrderType } from '../models/trade-edit.model';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class TradeService {
  public API = '//localhost:8080';
  public TRADE_API = this.API + '/trading';
  private tradeUrl = this.API + '/trading';
  private orderTypeUrl = this.API + '/trading';

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<any> {
    return this.http.get(this.API + '/trading');
  }

  // getBalance(acct_num: string) {
  //   return this.http.get(this.TRADE_API.'/' + acct_num);
  // }

  public getTrade() {
    return this.http.get<Trade[]>(this.tradeUrl);
  }

  public getAccount() {
    return this.http.get<Account[]>(this.tradeUrl + "/account");
  }

  public deleteTrade(trade) {
    return this.http.delete(this.tradeUrl + "/"+ trade.id);
  }

  // public getBalance(acct_num) {
  //   return this.http.get(this.tradeUrl + "/account/"+ acct_num);
  // }

  public getStockSymbol(stock_symbol): Observable<any> {
    return this.http.get(this.tradeUrl + "/stockSymbol/"+ stock_symbol);
  }

  // getStockSymbol(stock_symbol): Observable<any> {
  //   return this.http.get(this.tradeUrl + "/stockSymbol/"+ stock_symbol);
  // }

  public getStockPrice(tradeType, the_stock_symbol): Observable<any> {
    return this.http.get(this.tradeUrl + "/stockPrice/"+ tradeType +"/" + the_stock_symbol);
  }

  public createTrade(trade) {
    console.log("trade=", trade);
    return this.http.post<Trade>(this.tradeUrl, trade);
  }

  public getAllOrderTypes() {
    // console.log("trade=", trade);
    return this.http.get(this.orderTypeUrl + "/orderTypes");
  }

  remove(href: string) {
    return this.http.delete(href);
  }
}