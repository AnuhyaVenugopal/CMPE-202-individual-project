package com.anuhya.cmpe.billing;
import java.io.FileNotFoundException;
import java.util.List;

import com.anuhya.cmpe.controller.CheckItemAvailability;
import com.anuhya.cmpe.controller.CheckMaxCapHandler;
import com.anuhya.cmpe.controller.OrderCheckout;
import com.anuhya.cmpe.controller.ValidateHandler;
import com.anuhya.cmpe.controller.ValidateInventoryHandler;
import com.anuhya.cmpe.db.Database;
import com.anuhya.cmpe.file.ReadInput;
import com.anuhya.cmpe.model.Request;
import com.anuhya.cmpe.file.WriteOutput;
import com.anuhya.cmpe.model.FinalOrder;

public class Billing {

	public static void main(String[] args) {
		//1. Intiliaze database
		Database data = Database.getInstance();
		
		//2. Read input file 
		if(args.length==0){
            System.out.println("NO INPUT FILE!");
            System.exit(0);
        }
		else {
			String inputFile = args[0]; 
			ReadInput csvReader= new ReadInput();
			try {
				List<Request> orders= csvReader.inputFileReader(inputFile);
				//3. Build chain and process the input
				ValidateHandler obj1= new CheckItemAvailability();
				ValidateHandler obj2= new ValidateInventoryHandler();//check if stock is present
				ValidateHandler obj3= new CheckMaxCapHandler(); // input validation 3
				ValidateHandler obj4= new OrderCheckout();
				obj1.nextHandler(obj2);
				obj2.nextHandler(obj3);
				obj3.nextHandler(obj4);
				obj1.handle(orders);
				
			} 
			catch (FileNotFoundException e) {
				e.printStackTrace();
			}	
		}
	}
}
