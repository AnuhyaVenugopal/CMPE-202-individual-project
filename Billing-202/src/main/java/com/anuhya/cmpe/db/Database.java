package com.anuhya.cmpe.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import com.anuhya.cmpe.model.Items;
import com.anuhya.cmpe.model.Request;

public class Database {
	
	private static Database instance;
	private HashMap<String,Items> itemsList = new HashMap<String, Items>();
    private HashSet<String> cardsList = new HashSet<String>();
    
	public HashMap<String, Items> getItems() {
		return itemsList;
	}
	
	public HashSet<String> getCards() {
		return cardsList;
	}
	private Database() {
		//Add to itemsList
		itemsList.put("clothes", new Items("clothes", "Essentials",100, 20));
		itemsList.put("soap", new Items("soap", "Essentials",200, 5));
		itemsList.put("shampoo", new Items("shampoo", "Essentials",200, 10));
		itemsList.put("milk", new Items("milk", "Essentials",100, 5));
		itemsList.put("perfume", new Items("perfume", "Luxury",50, 50));
		itemsList.put("chocolates", new Items("chocolates", "Luxury",300, 3));
		itemsList.put("handbag", new Items("handbag", "Luxury",75, 150));
		itemsList.put("wallet", new Items("wallet", "Luxury",100, 100));
		itemsList.put("bedsheet", new Items("bedsheet", "Misc",150, 75));
		itemsList.put("footware", new Items("footware", "Misc",200, 25));
		itemsList.put("homedecorpiece", new Items("homedecorpiece", "Misc",100, 40));
		itemsList.put("pen", new Items("pen", "Misc",400, 3));
		itemsList.put("pencil", new Items("pencil", "Misc",400, 3));
		
		//Add to cardsList
	    cardsList.add("5.41E+15");
	    cardsList.add("4.12E+12");
	    cardsList.add("3.41E+14");
	    cardsList.add("6.01E+15");
	}
	public static Database getInstance() {
		
        if( instance == null){
            instance = new Database();
        }
        return instance;
    }
}
