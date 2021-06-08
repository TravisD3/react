import { Component, OnInit, ViewChild } from '@angular/core';
import { PortfolioService } from '../services/portfolio.service';
import {MatTableDataSource, MatSort} from '@angular/material';

// export class Polis{
//   constructor(
//     public PORTFOLIOID,
//     public ACCTNUM,
//     public DAYSGAIN,
//     public LAST,
//     public MARKETVALUE,
//     public PERCENTGAIN,
//     public QUANTITY,
//     public SYMBOL,
//     public TOTALGAIN
//   ){}
// }

@Component({
  selector: 'app-portfolios-list',
  templateUrl: './portfolios-list.component.html',
  styleUrls: ['./portfolios-list.component.css']
})
export class PortfoliosListComponent implements OnInit {
  portfolio: Array<any>;

  constructor(private portfolioService: PortfolioService) { }

  ngOnInit() {
    this.portfolioService.getAll().subscribe((data:(any)) => {
      this.dataSource.data = data;
      console.dir(this.dataSource);
    });
    this.dataSource.sort = this.sort;
  }

displayedColumns: string[] = ['portfolioid','acctnum','quantity','symbol','marketvalue','daysgain','totalgain','percentgain','last'];

dataSource = new MatTableDataSource(this.dataSource);

@ViewChild(MatSort, {static: true}) sort: MatSort;

applyFilter(filterValue: string) {
  //console.log(filterValue);
  filterValue = filterValue.trim().toLowerCase();
  //console.log(this.dataSource);
  this.dataSource.filter = filterValue;
  
}

}
