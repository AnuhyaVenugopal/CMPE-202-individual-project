package com.anuhya.cmpe.controller;

import java.util.HashMap;
import java.util.List;

import com.anuhya.cmpe.db.Database;
import com.anuhya.cmpe.file.OutputFileFactory;
import com.anuhya.cmpe.model.Request;

public class ValidateInventoryHandler extends ValidateHandler{
	//TO check if we have the quantity available

	private ValidateHandler next;
	@Override
	public void nextHandler(ValidateHandler next) {
		this.next=next;
	}

	@Override
	public void handle(List<Request> orders) {
		boolean flag = false;
		String w = "";
		Database data = Database.getInstance();
		// validate by looping through orders.
		for(Request r : orders) {
			if(data.getItems().get(r.getItemRequest()).getItemQuantity()<r.getQuantity()) {
				flag = true;
				w= w + r.getItemRequest()+": "+ r.getQuantity()+"\n";
			}
		}
		if(flag) {
			//write to error file
			StringBuilder fileText = new StringBuilder();
			fileText.append("Error: Please correct item quantities \n"+"Inventory doesnot have requested quantity \n" + w);
			OutputFileFactory out = new OutputFileFactory();
			out.getFileType("error").WriteOutputFile(fileText.toString());
			
		}else {
			next.handle(orders);
		}
	}
}
