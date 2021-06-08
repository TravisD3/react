import { Component, OnInit, ViewChild } from '@angular/core';
import { OrdersService } from '../services/orders.service';
import { GiphyService } from '../services/giphy.service';

import { MatPaginator, MatSort, MatTableDataSource} from '@angular/material';

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersComponent implements OnInit {

  constructor(private orderService: OrdersService, private giphyService: GiphyService) { }
  

  
  ngOnInit() {
    this.orderService.getAll().subscribe((resources) => {
      this.dataSource.data = resources;

      console.dir(this.dataSource);
    });
    this.dataSource.sort = this.sort;
    this.dataSource.paginator = this.paginator;
  }

  displayedColumns: string[] = ['TradeID', 'AccountNumber', 'CurrentFund', 'RemainFund', 'TotalPrice', 'CurrentPrice', 'Shares', 'StockSymbol', 'TradeTime', 'TradingPrice', 'TradeType', 'Current', 'Stock'];
  
  dataSource = new MatTableDataSource(this.dataSource);
  
  @ViewChild(MatSort, {static: true}) sort: MatSort;
  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;

  applyFilter(filterValue: string) {
    filterValue = filterValue.trim().toLowerCase();
    this.dataSource.filter = filterValue;
  }
}

// export interface Element {
//   TradeID: number;
//   AccountNumber: number;
//   CurrentFund: number;
//   RemainFund: number;
//   TotalPrice: number;
//   CurrentPrice: number;
//   Shares: number;
//   StockSymbol: string;
//   TradeTime: number;
//   TradingPrice: number;
//   TradeType: number;
//   Current: number;
//   Stock: string;
// }
