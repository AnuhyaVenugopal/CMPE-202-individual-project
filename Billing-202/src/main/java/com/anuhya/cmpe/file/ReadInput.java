package com.anuhya.cmpe.file;
import com.anuhya.cmpe.model.Request;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadInput {
	BufferedReader br;
    
    public List<Request> inputFileReader(String path) throws FileNotFoundException {
    	// 1. open file
        File file = new File(path);
        FileReader fr = new FileReader(file);
        this.br = new BufferedReader(fr);
        Request order= null;
        List<Request> ordersList=new ArrayList<>();
        // 2. read values
        try {
        	String line;
			line= br.readLine();
			line= br.readLine();
			while(line!=null) {
	        	String[] requestValues = line.split(",");
	        	if(requestValues.length<2) {
	        		System.out.println("Wrong input file");
	        	}
	        	String name = requestValues[0].toLowerCase();
	        	int quantity = Integer.parseInt(requestValues[1]);
	        	String cardNumber;
	        	if(requestValues.length<3) {
	        		cardNumber = "";
	        	}
	        	else {
	        		cardNumber = requestValues[2];
	        	}
	        	order = new Request(name, quantity, cardNumber);
	        	ordersList.add(order);
	        	line= br.readLine();
	        }
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ordersList; 
    }
    
}
