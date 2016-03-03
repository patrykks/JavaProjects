package edu.agh.jtplab.zad2;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class Main {
	private static void randVector(double [] a)
	{
		Random rand = new Random();
		for(int i=0;i<a.length;i++)
		{
			a[i] = rand.nextDouble();
		}
	}
	/**
	 * @param args
	 */
	// it makes no sense to create more threads than available cores (no speed improvement here)
    private static final int AVAILABLE_PROCESSORS = Runtime.getRuntime().availableProcessors();

    // create thread pool
    private static final ForkJoinPool pool = new ForkJoinPool(AVAILABLE_PROCESSORS);
	
    
    public static void main(String[] args) {
        final int index=100000000;
    	double [] a = new double[index];
        double [] b = new double[index];
        long startTime;
        long endTime;
        randVector(a);
        randVector(b);
    	// Sequential computing
        startTime = System.currentTimeMillis();
        System.out.println("Sequential computing result ="+SequentialDotProduct.count(a, b));
        endTime =  System.currentTimeMillis();
        System.out.println("Sequential computing took " + (endTime - startTime) + " milliseconds");
        final ParralelDotProducts task = new ParralelDotProducts(index,a,b);
    	startTime = System.currentTimeMillis();
        final Double result = pool.invoke(task);
        endTime =  System.currentTimeMillis();
        System.out.println("Parralel computing result = " + result);
        System.out.println("Parralel computing took " + (endTime - startTime) + " milliseconds");


	}

}
