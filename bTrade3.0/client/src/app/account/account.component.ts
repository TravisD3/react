import { Component, OnInit } from '@angular/core';
import { AccountService } from '../services/account.service';


@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.css']
})
export class AccountComponent implements OnInit {
  accounts: any;
  accountTypes: any;
  errorMessage: string;
  selectedAccountType: string;

  columnsToDisplay: string[] = ['acct_num', 'acct_type', 'avail_balance'];
 
  constructor(private accountService: AccountService) { }
 
  ngOnInit() {
      this.accountService.getAccountTypes().subscribe(
      data => {
        this.accountTypes = data;
        console.log("types=" + data);
      },
      error => {
        this.errorMessage = `${error.status}: ${JSON.parse(error.error).message}`;
      }
    );

    this.accountService.getAccounts().subscribe(
      data => {
        this.accounts = data;
        console.log("accounts=" + data);
      },
      error => {
        this.errorMessage = `${error.status}: ${JSON.parse(error.error).message}`;
      }
    );
  }
}