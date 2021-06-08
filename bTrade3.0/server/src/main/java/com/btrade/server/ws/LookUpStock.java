package com.btrade.server.ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.btrade.server.model.Stock;

import yahoofinance.YahooFinance;
import yahoofinance.quotes.stock.StockQuote;

public class LookUpStock 
{

	@SuppressWarnings("unused")
	public static List<Stock> getStockSymbol(String name)
	{
		
		String s1="http://d.yimg.com/autoc.finance.yahoo.com/autoc?query=";
		String s2="&region=USA&lang=English";
		String s = s1+name+s2;
		List<Stock> l = new ArrayList<Stock>();
		try
		{
			URL url=new URL(s);
		
			System.out.println("s = " + s);
		
			URLConnection con = url.openConnection();
			InputStream is =con.getInputStream();
        
        	BufferedReader br = new BufferedReader(new InputStreamReader(is));
        	
        	String line;
        	while((line = br.readLine())!=null)
        	{

        		JSONObject json = new JSONObject(line);
        		System.out.println("line="+line);
			//String symbol = json.getString("ResultSet");
        		// json是一个JSONObject, 里头有一个 "ResultSet" --> json 对象， json对象里头"Rresult" --> JSONArray, JSONArray存放的是JSON对象的数组
        		json = json.getJSONObject("ResultSet");
        		//System.out.println("After get ResultSet!!!!!!!!!!!!!!!");
        		JSONArray array = json.getJSONArray("Result");
        		
      //-----------------------------------------------------  		
        		//System.out.println("After get JSONArray!!!!!!!!!!!!!!!");	
        		String symbol="";
        		String stname="";
        		
        		for (int i = 0; i < array.length(); i++) 
        		{
        			JSONObject rec = array.getJSONObject(i);
        			//int id = rec.getInt("id");
        			//System.out.println("id = " + id);
        			symbol = rec.getString("symbol");
        			stname = rec.getString("name");
        			// ...
        			System.out.println("symbol="+symbol);
        			//break;
        			Stock stock = new Stock();
        			stock.setStockSymbol(symbol);
        			stock.setName(stname);
        			l.add(stock);
        		}
			
//        		Stock stock = new Stock();
//        		stock.setStockSymbol(symbol);
//			
//        		l.add(stock);
//			
        		break;
        		
        		//-----------------------------------------------------  		  		
        		
			}
        	
		} catch(IOException e){
			e.printStackTrace();
		}catch( JSONException j){
			System.out.print("json="+j );
		}
		return l;	
		
	}
	
	public static double getStockPrice(String tradeType, String symbol)
	{
		/**
		System.out.println("tradeType in price:"+tradeType);
		String s1="https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20yahoo.finance.quotes%20where%20symbol%20in%20(%22";
		String s2="%22)&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys&callback=";
		String s = s1+symbol+s2;
		System.out.println("In get Stock Price s = "+ s);
		//https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20yahoo.finance.quotes%20where%20symbol%20in%20(%22goog%22)&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys&callback=
		List<Stock> l = new ArrayList<Stock>();
		//System.out.println("2tradeType in price:"+tradeType);
		try
		{
			URL url=new URL(s);
		
			URLConnection con = url.openConnection();
			InputStream is =con.getInputStream();
        
        	BufferedReader br = new BufferedReader(new InputStreamReader(is));
        	String line;
        	
			//Ask is the price for the customer to buy
			//Bid is the price for the customer to sell
        	
        	while((line = br.readLine())!=null)
        	{

    			JSONObject json = new JSONObject(line);
    			System.out.println("line="+line);
    			//String symbol = json.getString("ResultSet");
    			
    			json = json.getJSONObject("query");
    			json = json.getJSONObject("results");
    			json = json.getJSONObject("quote");
    			
    			//double bid = json.getDou("Bid");
    			double bid = json.getDouble("Bid");
    			double ask = json.getDouble("Ask");
    			
    			double price;
    			
    			//Ask is the price for the customer to buy
    			//Bid is the price for the customer to sell
    			if(tradeType.equals("Buy"))
    				price = ask;
    			else
    				price = bid;
    			
    			System.out.println("price = "+ price);
    			Stock stock1 = new Stock();
    			stock1.setStockPrice(price);
    			
    			l.add(stock1);
    			
            	break;  
    		}       	
			
		} 
		catch(IOException e)
		{
			e.printStackTrace();
		}
		catch( JSONException j)
		{
			System.out.println("price"+j);
		}
		return l;
		*/
		double price = 0;
		YahooFinance yahoo = new YahooFinance();
		try 
		{
//			System.out.println("symbol = " + symbol);
//			yahoofinance.Stock yahooStock = yahoo.get(symbol);
//			StockQuote sq = yahooStock.getQuote();
//			double price;
//			if (tradeType.equals("Buy"))
//				price = sq.getAsk().doubleValue();
//			else
//				price = sq.getBid().doubleValue();
//			System.out.println("trade type: " + tradeType + " price = " + price);
//			Stock stock = new Stock();
//			stock.setStockSymbol(symbol);
//			stock.setStockPrice(price);
//			l.add(stock);
			
			
			
			System.out.println("symbol = " + symbol);
			yahoofinance.Stock yahooStock = yahoo.get(symbol);
			StockQuote sq = yahooStock.getQuote();
			if (tradeType.equals("Buy"))
				price = sq.getAsk().doubleValue();
			else
				price = sq.getBid().doubleValue();
			System.out.println("trade type: " + tradeType + " price = " + price);		
			
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return price;
	}
}
