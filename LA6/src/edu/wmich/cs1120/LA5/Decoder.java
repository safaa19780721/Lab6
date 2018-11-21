package edu.wmich.cs1120.LA5;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.file.Paths;
import java.util.Scanner;

public class Decoder implements IDecoder {
	
	public void decode(String filePath) {
		String lineInFile = "";
		String msg = "";
		int distance = 0;
		char repeatedChar;
		try {
			RandomAccessFile in = new RandomAccessFile(filePath, "rw");
			while(distance != -1) {
				lineInFile = lineInFile + in.readChar();
				distance = in.readInt();
				for(int i = 0; i < distance; i ++) {
					in.read();
				}
			}
			
			
		}
		catch(Exception e) {
			System.out.println(filePath + " could not be found.");
		}
		System.out.println(lineInFile);
	}

}
