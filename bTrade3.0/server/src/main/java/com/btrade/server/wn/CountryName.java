package com.btrade.server.wn;

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

import com.btrade.server.model.Homeland;
import com.btrade.server.model.Stock;

public class CountryName {

	@SuppressWarnings("unused")
	public static List<Homeland> getCountrySymbol(String name) {
		
		String s1="http://d.yimg.com/autoc.finance.yahoo.com/autoc?query=";
		String s2="&region=USA&lang=English";
		String s = s1+name+s2;
		List<Homeland> l = new ArrayList<Homeland>();
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
        			Homeland homeland = new Homeland();
        			homeland.setCountrySymbol(symbol);
        			homeland.setMycountry(stname);
        			l.add(homeland);
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
	
}
