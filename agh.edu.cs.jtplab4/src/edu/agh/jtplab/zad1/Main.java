package edu.agh.jtplab.zad1;

public class Main {
	public static void main(String [] argv)
	{
		try {
			FileWalker.walk("./PAM08");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
