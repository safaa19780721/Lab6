package edu.wmich.cs1120.LA5;

import java.io.File;
import java.util.Scanner;

public class Decoder implements IDecoder {
	
	public void decode(String filePath) {
		String lineInFile = "";
		String msg = "";
		char repeatedChar;
		try {
			File binFile = new File(filePath);
			Scanner in  = new Scanner(binFile);
			while(in.hasNext()) {
				lineInFile = lineInFile + in.next();
			}
		}
		catch(Exception e) {
			System.out.println(filePath + " could not be found.");
		}
		
		for(int i = 0; i < lineInFile.length(); i ++) {
			repeatedChar = lineInFile.charAt(i+1);
			switch(lineInFile.charAt(i)) {
				case('1'):
					i += 4;
					break;
				case('2'):
					i+= 5;
					break;
				case('3'):
					i+= 6;
					break;
				case('4'):
					i+= 7;
					break;
				case('5'):
					i+= 8;
					break;
				case('6'):
					i+= 9;
					break;
				case('7'):
					i+= 10;
					break;
				case('8'):
					i+= 11;
					break;
				case('9'):
					i+= 12;
					break;
				case('-'):
					i = lineInFile.length();
					break;
				default:
					if(lineInFile.charAt(i) == repeatedChar) {
						break;
					}
					else
						msg = msg + lineInFile.charAt(i);
					break;
				
			}
		}
		System.out.println(msg);
	}

}
