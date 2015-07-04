package edu.agh.jtplab.zad2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;



public class FileAnalyzer {
	private TreeMap<String, Integer> wordsMap;
	
	public FileAnalyzer()
	{
		wordsMap = new TreeMap<String,Integer>();
	}
	public void readBook() throws IOException
	{
		BufferedReader in = new BufferedReader(new FileReader("book.txt"));
	    String line = "";
	    while ((line = in.readLine()) != null) {
	    	line = line.replace(","," ").replace(".", " ").replace(":", " ").replace(";"," ").replace("?", " ").replace("\"", " ").replace("'", " ").replace("("," ").replace(")", " ").replace("`", " ");
	    	String [] words = line.split(" ");
	    	for (String word: words)
	    	{
	    		if (word.compareTo("")!=0) 
	    		{
	    			if (wordsMap.containsKey(word)) 
	    			{
	    				wordsMap.put(word, wordsMap.get(word)+1);
	    			} else
	    				wordsMap.put(word,1);
	    			
	    		}
	    	}
	    }
	    in.close();
	}
	
	public void printWords()
	{
		for(Map.Entry<String,Integer> entry : wordsMap.entrySet()) {
			  String key = entry.getKey();
			  Integer value = entry.getValue();
			  System.out.println(key + " => " + value);
		}
	}
	
	static <K,V extends Comparable<? super V>> SortedSet<Map.Entry<K,V>> entriesSortedByValues(Map<K,V> map) {
        SortedSet<Map.Entry<K,V>> sortedEntries = new TreeSet<Map.Entry<K,V>>(
            new Comparator<Map.Entry<K,V>>() {
                @Override public int compare(Map.Entry<K,V> e1, Map.Entry<K,V> e2) {
                    int res = e2.getValue().compareTo(e1.getValue());
                    return res != 0 ? res : 1; // Special fix to preserve items with equal values
                }
            }
        );
        sortedEntries.addAll(map.entrySet());
        return sortedEntries;
    }
	
	void printMostOftenWords(int num)
	{
		int i=0;
		SortedSet<?> sorted = entriesSortedByValues(wordsMap);
		
	    Iterator<?> it = sorted.iterator();
	    while (it.hasNext() && i<num) {
	    	Entry<String, Integer> entry = (Entry<String, Integer>) it.next();
			System.out.println(entry.getKey()+"=>"+entry.getValue());
	    	i++;
	    }
	}
	
	
}
