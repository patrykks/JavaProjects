package edu.agh.jtplab.zad2;

public class SequentialDotProduct {
	public static Double count(double [] A,double [] B)
	{
		double result =  0.0;
		if (A.length != B.length) 
			return  0.0;
		for (int i=0;i<A.length;i++)
		{
			result+=A[i]*B[i];
		}
		return result;
	}
}
