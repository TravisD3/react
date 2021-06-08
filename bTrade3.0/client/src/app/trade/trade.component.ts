import { Component, OnInit } from '@angular/core';
import { TradeService } from '../services/trade.service';
import { GiphyService } from '../services/giphy.service';

@Component({
  selector: 'app-trade',
  templateUrl: './trade.component.html',
  styleUrls: ['./trade.component.css']
})
export class TradeComponent implements OnInit {
  trades: Array<any>;

  constructor(private tradeService: TradeService, private giphyService: GiphyService) { }

  ngOnInit() {
    this.tradeService.getAll().subscribe(data => {
      this.trades = data;
      for (const trade of this.trades) {
        this.giphyService.get(trade.tradeId).subscribe(url => trade.giphyUrl = url);
      }
    });
  }
}
