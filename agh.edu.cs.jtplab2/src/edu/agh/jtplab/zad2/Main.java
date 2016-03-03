package edu.agh.jtplab.zad2;

import java.io.File;
import java.io.IOException;

public class Main {
	public static void main(String [] argv)
	{
		try {
			CopyMaker.copy(new File("photo.jpg"), new File("photo_copy.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Copy files operation error");
		}
	}
}
