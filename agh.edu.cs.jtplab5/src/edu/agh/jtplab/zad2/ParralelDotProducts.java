package edu.agh.jtplab.zad2;

import java.util.concurrent.RecursiveTask;

public class ParralelDotProducts extends RecursiveTask<Double> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int index;
	private final double [] a;
	private final double  [] b;
	private final int n = 100000;
	public ParralelDotProducts(int index,double [] a,double [] b)
	{
		this.a=a;
		this.b=b;
		this.index= index;
	}
	@Override
	protected Double compute() {
		if (index<n)
		{
			double rslt = 0.0f;
			for (int i=index-1;i>=0;i--)
			{
				rslt+=a[i]*b[i];
			}
			
			return rslt;
		} else
		{
			final ParralelDotProducts firstWorker = new ParralelDotProducts(index-n, a, b);
			firstWorker.fork();
			double result = 0.0f;
			for (int i=index-1;i>=index-n;i--)
			{
				result+=a[i]*b[i];
			}
			return result + firstWorker.join();

		}
	}
	
}
