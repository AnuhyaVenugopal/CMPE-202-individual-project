package com.anuhya.cmpe.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.anuhya.cmpe.db.Database;
import com.anuhya.cmpe.file.OutputFileFactory;
import com.anuhya.cmpe.model.FinalOrder;
import com.anuhya.cmpe.model.Request;

public class OrderCheckout extends ValidateHandler {

		@Override
		public void nextHandler(ValidateHandler next) {
			// TODO Auto-generated method stub
			//No next handler.
		}

		@Override
		public void handle(List<Request> orders) {
			// TODO Auto-generated method stub
			double finalPrice =0;
            Database data= Database.getInstance();
			for(Request r: orders) {
				finalPrice+= r.getQuantity()* data.getItems().get(r.getItemRequest()).getItemPrice();
			}
			StringBuilder fileText = new StringBuilder();
			fileText.append("Item,Quantity,Price,FinalPrice\n");
			for(Request r:orders) {
				fileText.append(r.getItemRequest()+","+r.getQuantity()+","+data.getItems().get(r.getItemRequest()).getItemPrice()+",\n");
			}
			fileText.append(" , , ,"+finalPrice);
			System.out.println("Final Price: "+ finalPrice);
			OutputFileFactory out = new OutputFileFactory();
			out.getFileType("output").WriteOutputFile(fileText.toString());
			
			
		}
}
