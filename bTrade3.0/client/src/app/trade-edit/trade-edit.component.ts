import { Component, OnDestroy, OnInit, NgModule } from '@angular/core';
import { Subscription } from 'rxjs';
import { ActivatedRoute, Router } from '@angular/router';
import { TradeService } from '../services/trade.service';
import { NgForm, AbstractControl, FormBuilder, FormGroup } from '@angular/forms';
import { GiphyService } from '../services/giphy.service';
import { Trade, Stock, Account, OrderType } from '../models/trade-edit.model';
import { FormControl, Validators } from '@angular/forms';
import { Observable } from 'rxjs';
import { map, startWith } from 'rxjs/operators';
import { MatSnackBar } from '@angular/material';


@Component({
  selector: 'app-trade-edit',
  templateUrl: './trade-edit.component.html',
  styleUrls: ['./trade-edit.component.css']
})
export class TradeEditComponent implements OnInit {
  trades: Trade[];
  trade: Trade = new Trade();

  stocks: Array<any>;
  accounts: Account[];
  account: Account = new Account();

  orderTypes: any;
  orderType: OrderType = new OrderType();

  electedOrderType: number;


  balance: number;
  stocksym: String[];
  stockPrice: any;
  stockName: String;
  blanceChange: any;

  mysubscription: Subscription;

  // ------------Validators----------
  registerForm: FormGroup;
  submitted = false;
  // ------------Validators----------


  constructor(private router: Router, private tradeService: TradeService, private formBuilder: FormBuilder, private snackBar: MatSnackBar) {
  }

  ngOnInit() {
    this.tradeService.getTrade()
      .subscribe(data => {
        this.trades = data;
      });
    this.trade.tradeType = 'Buy';
    this.trade.uidNo = 1;
    
    // -----------------get account------------
    this.tradeService.getAccount()
      .subscribe(data => {
        this.accounts = data;
      });

    //---------------- -get order types--------
    this.tradeService.getAllOrderTypes()
      .subscribe(data => {
       this.orderTypes = data;
      });
      // console.log("This is : "+this.orderTypes);
      

    // this.getBalance(this.trade.accNumber);
    //  ------------Validators----------
    this.registerForm = this.formBuilder.group({

      tradeNumberOfShares: ['', [Validators.required, Validators.pattern("^(0*[1-9][0-9]*(\.[0-9]+)?|0+\.[0-9]*[1-9][0-9]*)$")]],
      tradeTradingPrice: ['', [Validators.required, Validators.pattern("^^(0*[1-9][0-9]*(\.[0-9]+)?|0+\.[0-9]*[1-9][0-9]*)$")]],
      accountBalance: ['', [Validators.required]],
      stockSymbol: ['', [Validators.required]],
      stockPrice: ['', [Validators.required]]
    });

  };


  deleteUser(user: Trade): void {
    this.tradeService.deleteTrade(Trade)
      .subscribe(data => {
        this.trades = this.trades.filter(u => u !== this.trade);
      })
  };



  // getBalance(acct_num: any): any {
  //   this.tradeService.getBalance(acct_num).subscribe(data => {
  //     this.balance = Number(data);
  //   });
  // }


  onInputChanged(type_stock_symbol: string): void {
    type_stock_symbol = type_stock_symbol.trim();
    if (type_stock_symbol != '') {
      //this.stocks = [];
      if (this.mysubscription) {
        this.mysubscription.unsubscribe();
      }
      this.mysubscription = this.tradeService.getStockSymbol(type_stock_symbol).subscribe(data => {
        this.stocks = data;
      });

    }
  }

  setTheStockSymbol(selected_stockSymbol, selected_stockName) {
    this.trade.tradeStockSymbol = selected_stockSymbol;
    this.stockName = selected_stockName;
    this.registerForm.controls.stockSymbol.reset(selected_stockSymbol);
    this.getStockPrice(this.trade.tradeType, this.trade.tradeStockSymbol);
  }

  getStockPrice(tradeType: String, the_stock_symbol: String): any {
    if (the_stock_symbol != null && the_stock_symbol != '') {
      the_stock_symbol = the_stock_symbol.trim();
      this.tradeService.getStockPrice(tradeType, the_stock_symbol).subscribe(data => {
        this.stockPrice = data;
        this.trade.tradeCurrentPrice = data;
        this.registerForm.controls.stockPrice.reset(data);
      });
    }
  }
  getBlanceChange(tradeShares, stockPrice): any {
    this.blanceChange = tradeShares * stockPrice;
  }

  setAccount(Account: Account) {
    if (Account != null) {
      this.balance = Account.avail_balance;
      this.trade.accNumber = Account.acct_num;
    }
  }

  calculateTradingPrice(tradePrice, tradeNumberOfShares): any {
    this.trade.totalPrice = parseFloat((tradePrice * tradeNumberOfShares).toFixed(2));
    this.trade.currentFund = this.balance;
    if (this.trade.tradeType == 'Buy') {
      this.trade.remainFund = parseFloat((this.balance - this.trade.totalPrice).toFixed(2));
    }
    else {
      this.trade.remainFund = parseFloat((this.balance + this.trade.totalPrice).toFixed(2));
    }
  }

  get f() { return this.registerForm.controls; }

  openSnackBar(message: string, action: string) {

    let panelClass;
    if (action == 'Succeeded') {
      panelClass = ['green-snackbar'];
    } else {
      panelClass = ['red-snackbar'];
    }

    this.snackBar.open(message, action, {
      duration: 2000,
      panelClass: panelClass
    }
    );

  }


  createTrade(): void {
    this.submitted = true;
    if (this.registerForm.invalid) {
      //alert(' illegal inputs, Please try another value!! ')
      this.openSnackBar(' Illegal inputs, Please try another value!', 'Failed')
    }
    else if (this.trade.remainFund < 0) {
      this.openSnackBar(' You current ballance is not enough for this trade!', 'Failed')
    }
    else {
	  //console.log("trade", this.trade);
      this.tradeService.createTrade(this.trade)
        .subscribe(data => {
          this.openSnackBar(' Trade created successfully.', 'Succeeded')
        });
    }
  };

}
