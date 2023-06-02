package com.anuhya.cmpe.controller;

import java.util.List;
import com.anuhya.cmpe.db.Database;
import com.anuhya.cmpe.file.OutputFileFactory;
import com.anuhya.cmpe.model.Request;

public class CheckItemAvailability extends ValidateHandler {
	// TO Check if the item is available or not
	
	private ValidateHandler next;
	@Override
	public void nextHandler(ValidateHandler next) {
		this.next=next;
	}

	@Override
	public void handle(List<Request> orders) {
		boolean flag = false;
		String w="";
		Database data = Database.getInstance();
		// validate by looping through orders.
		for(Request r : orders) {
			if(!(data.getItems().containsKey(r.getItemRequest()))) {
				flag= true;
				w= w+ r.getItemRequest()+"\n";
			}
		}
		if(flag) {
			//write to error file
			StringBuilder fileText = new StringBuilder();
			fileText.append("Error: Requested Items not available \n" + w);
			OutputFileFactory out = new OutputFileFactory();
			out.getFileType("error").WriteOutputFile(fileText.toString());
			
		}else {
			next.handle(orders);
		}
	}
}
