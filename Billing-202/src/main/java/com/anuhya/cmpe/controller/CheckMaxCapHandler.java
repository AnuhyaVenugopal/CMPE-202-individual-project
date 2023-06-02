package com.anuhya.cmpe.controller;

import java.util.HashMap;
import java.util.List;

import com.anuhya.cmpe.db.Database;
import com.anuhya.cmpe.file.OutputFileFactory;
import com.anuhya.cmpe.model.Request;

public class CheckMaxCapHandler extends ValidateHandler {
	// TO check the limit based on categories
	
    private final int essentials = 3;
    private final int luxury = 4;
    private final int misc = 6;
	private ValidateHandler next;
	
	@Override
	public void nextHandler(ValidateHandler next) {
		this.next=next;
	}

	@Override
	public void handle(List<Request> orders) {
		boolean flag = false;
		HashMap<String,Integer> catCheck = new HashMap<>();
		Database data = Database.getInstance();
		// validate by looping through orders.
		for(Request r : orders) {
			catCheck.put(data.getItems().get(r.getItemRequest()).getItemCatergory(), catCheck.getOrDefault(data.getItems().get(r.getItemRequest()).getItemCatergory(), 0)+r.getQuantity());
		}
		if(catCheck.getOrDefault("Luxury", 0)>4) {flag = true;}
		else if(catCheck.getOrDefault("Essentials", 0)>3) {flag = true;}
		else if(catCheck.getOrDefault("Misc", 0)>6) {flag = true;}
		
		if(flag) {
			//write to error file
			StringBuilder fileText = new StringBuilder();
			fileText.append("Error: Cannot order the items due to category cap");
			OutputFileFactory out = new OutputFileFactory();
			out.getFileType("error").WriteOutputFile(fileText.toString());
		}else {
			next.handle(orders); // Send to order checkout		}
		}
	}
}
