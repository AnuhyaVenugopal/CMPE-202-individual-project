package com.anuhya.cmpe.file;

public class OutputFileFactory {
	public OutputFile getFileType(String type) {
		if(type.equals("error")) {
			return new WriteError();
		}
		else {
			return new WriteOutput();
		}
	}
}
