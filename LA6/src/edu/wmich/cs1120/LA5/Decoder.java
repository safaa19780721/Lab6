package edu.wmich.cs1120.LA5;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * 
 * @author MichaelCoffey&DylanTarnacki
 * This class is used to decode a binary file and print the message on screen
 *
 */
public class Decoder implements IDecoder {
	
	/**
	 * decode is used to read the file, decode the message, then print the new message on screen. Uses randomAccessFile and
	 * a while loop to search through the file. Finds a char then an int after. Skips how many spots the int says. Then get next char.
	 * Will throw an exception if the file can't be found.
	 */
	public void decode(String filePath) {
		String lineInFile = "";
		String msg = "";
		int distance = 0;
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
