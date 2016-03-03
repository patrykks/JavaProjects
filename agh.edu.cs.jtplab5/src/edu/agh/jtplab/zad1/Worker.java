package edu.agh.jtplab.zad1;

import java.util.Random;
import java.util.concurrent.Callable;

 
public class Worker implements Callable<Boolean> {
	private static final int r = 2;
	private static final int a = 2;
    @Override
    public Boolean call() throws Exception {
    	Double x;
    	Double y;
    	Random rand = new Random();
    	x = a*rand.nextDouble();
    	y = a*rand.nextDouble();
    	if (x*x+y*y<r*r)
    	{
    		return true;
    	}
        return false;
        //return Thread.currentThread().getName();
    }
}