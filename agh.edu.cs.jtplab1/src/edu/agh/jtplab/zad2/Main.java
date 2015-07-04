package edu.agh.jtplab.zad2;

import java.io.IOException;

public class Main {
	public static void main(String [] argv)
	{
		FileAnalyzer fileanalyzer = new FileAnalyzer();
		try {
			fileanalyzer.readBook();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fileanalyzer.printMostOftenWords(50);
	}
}
