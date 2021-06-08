export class Trade {
  tradeType: string;
  tradeStockSymbol: string;
  tradeCurrentPrice: number;
  tradeTradingPrice: number;
  totalPrice: number;
  currentFund: number;
  remainFund: number;
  accNumber: string;
  orderTypeId: number;
  uidNo: number;
}

export class Account {
  acct_Id: number;
  acct_num: string;
  avail_balance: number;
}

export class OrderType {
  orderTypeId: number;
  orderType: string;
}

export class Stock {
  symbol: string;
  name: string;
}