package main;

import java.io.BufferedReader;
import java.io.FileReader;

public class FileRead {

	FileReader fstream;
	BufferedReader bw;
	public FileRead(String fname) {
		try {
			fstream = new FileReader(fname);
			bw = new BufferedReader(fstream);
		} catch (Exception e) {
			System.err.println("Error for file: " + e.getMessage());
		}
	}

	public String readLine() {
		try {
			 return bw.readLine();
		} catch (Exception e) {
			System.err.println("Error for file: " + e.getMessage());
		}
		return null;
	}
	
	public boolean isReady() {
		try {
			 return bw.ready();
		} catch (Exception e) {
			System.err.println("Error for file: " + e.getMessage());
		}
		return false;
	}
	
	public void close() {
		try {
			bw.close();
		} catch (Exception e) {
			System.err.println("Error for file: " + e.getMessage());
		}
	}
}
