package com.anuhya.cmpe.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class WriteOutput implements OutputFile{
	
	@Override
	public void WriteOutputFile(String msg) {
		// TODO Auto-generated method stub
		File dir=new File("Files");
		if(!dir.exists()) {
			dir.mkdir();
		}
		File file= new File("Files/Output.csv");
		try(PrintWriter writer=new PrintWriter(file)){	
				writer.write(msg);
				writer.flush();
				writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Check Output.txt file in Files");
	}
}
