package edu.agh.jtplab.zad0;


public class Main {
	public static void main(String [] argv)
	{
		MedianFilter medianfilter = new MedianFilter("./mini.jpg");
		MeanFilter meanFilter = new MeanFilter("./mini.jpg");
		try {
			medianfilter.process();
			meanFilter.process();
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
