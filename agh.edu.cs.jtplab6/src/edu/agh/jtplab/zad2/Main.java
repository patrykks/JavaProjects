package edu.agh.jtplab.zad2;

public class Main {
	public static void main(String [] argv)
	{
		
		Filter filter = new Filter();
		try {
			filter.filter();
			filter.replaceObj();
			filter.filter();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
