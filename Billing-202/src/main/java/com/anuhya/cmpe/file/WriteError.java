package com.anuhya.cmpe.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class WriteError implements OutputFile {

	@Override
	public void WriteOutputFile(String msg) {
		// TODO Auto-generated method stub	
		File dir=new File("Files");
		if(!dir.exists()) {
			dir.mkdir();
		}
		File file= new File("Files/Error.txt");
		try(PrintWriter writer=new PrintWriter(file)){	
				writer.write(msg);
			writer.flush();
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Check Error.txt file in Files");
	}
	

}
