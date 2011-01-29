package main;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class FileWrite {

	FileWriter fstream;
	BufferedWriter bw;
	public FileWrite(String fname) {
		try {
			fstream = new FileWriter(fname);
			bw = new BufferedWriter(fstream);
		} catch (Exception e) {
			System.err.println("Error for file: " + e.getMessage());
		}
	}

	public void write(String line) {
		try {
			bw.write(line);
			bw.newLine();
			bw.flush();
		} catch (Exception e) {
			System.err.println("Error for file: " + e.getMessage());
		}
	}
	
	public void close() {
		try {
			bw.close();
		} catch (Exception e) {
			System.err.println("Error for file: " + e.getMessage());
		}
	}
}
