package edu.agh.jtplab.zad1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    public static void main(String args[]){
    	double round=0;
    	double square=0;
    	ExecutorService executor = Executors.newFixedThreadPool(10);
        List<Future<Boolean>> list = new ArrayList<Future<Boolean>>();
        Callable<Boolean> callable = new Worker();
        Random rand = new Random();
        for(int i=0; i< rand.nextInt(1000000000)	; i++){
            Future<Boolean> future = executor.submit(callable);
            list.add(future);
        }
        for(Future<Boolean> fut : list){
            try {
            	if (fut.get())
            	{
            		round++;
            	}
            	square++;
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        executor.shutdown();
        System.out.println("PI Value"+(double)(round/square*4));
    }
}
