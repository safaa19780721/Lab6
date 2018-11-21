package edu.wmich.cs1120.LA5;

import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Encoder implements IEncoder {
	
	Scanner input;
	RandomAccessFile output;
	Random rand;

	@Override
	public void encode(String inputFileName, String outputFilePath) {
		// TODO Auto-generated method stub
		String line;
		long nextPost = 0;
		int bytes = 0;
		
		try {
			input = new Scanner(new File(inputFileName));
			output = new RandomAccessFile(new File(outputFilePath), "rw");
			rand = new Random();
			output.setLength(0);
			while(input.hasNext()) {
				line = input.nextLine();
				for(int i = 0; i < line.length(); i++) {
					output.writeChar(line.charAt(i));
					bytes = rand.nextInt(20) + 1;
					output.writeInt(bytes);
					nextPost = output.getFilePointer() + bytes;
					output.seek(nextPost);
				}
				output.writeChar('\n');
				bytes = rand.nextInt(20) + 1;
				output.writeInt(bytes);
				nextPost = output.getFilePointer() + bytes;
				output.seek(nextPost);	
			}
			output.seek(nextPost - bytes - 4);
			output.writeInt(-1);
			output.close();
			input.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}

	}

}
