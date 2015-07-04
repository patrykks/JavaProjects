package edu.agh.jtplab.zad1;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
	public static void main(String [] argv)
	{
		ArrayList<Integer> list0=new ArrayList<Integer>();
		ArrayList<Integer> list1=new ArrayList<Integer>(10000000);
		LinkedList<Integer> list2 = new LinkedList<>();
		long [] startTime = new long [3] ;
		long [] endTime = new long [3] ;
		
		startTime[0]=System.currentTimeMillis();
		for (int i=0;i<10000000;i++)
		{
				list0.add(i);
		}
		endTime[0] = System.currentTimeMillis();
		System.out.println("ArrayList without initial capacity add time: " + (endTime[0] - startTime[0]) + " milliseconds");
		
		startTime[1]=System.currentTimeMillis();
		for (int i=0;i<10000000;i++)
		{
				list1.add(i);
		}
		endTime[1] = System.currentTimeMillis();
		System.out.println("ArrayList with initial capacity add time: " + (endTime[1] - startTime[1]) + " milliseconds");
		
		startTime[2]=System.currentTimeMillis();
		for (int i=0;i<10000000;i++)
		{
				list2.add(i);
		}
		endTime[2] = System.currentTimeMillis();
		System.out.println("LinkedList add time: " + (endTime[2] - startTime[2]) + " milliseconds");
		// DELETING----------------------------------------------------------
		
		startTime[0]=System.currentTimeMillis();
		for (int i=0;i<1000;i++)
		{
				list0.remove(i);
		}
		endTime[0] = System.currentTimeMillis();
		System.out.println("ArrayList without initial capacity remove time: " + (endTime[0] - startTime[0]) + " milliseconds");
		
		startTime[1]=System.currentTimeMillis();
		for (int i=0;i<10000;i++)
		{
				list1.remove(i);
		}
		endTime[1] = System.currentTimeMillis();
		System.out.println("ArrayList with initial capacity remove time: " + (endTime[1] - startTime[1]) + " milliseconds");
		
		startTime[2]=System.currentTimeMillis();
		for (int i=0;i<10000;i++)
		{
				list2.remove(i);
		}
		endTime[2] = System.currentTimeMillis();
		System.out.println("LinkedList remove time: " + (endTime[2] - startTime[2]) + " milliseconds");

	}
}
