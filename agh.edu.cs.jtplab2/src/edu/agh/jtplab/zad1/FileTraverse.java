package edu.agh.jtplab.zad1;

import java.io.File;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;


public class FileTraverse {
		private SortedSet<MyFile> sortedSet;
		
		public FileTraverse() {
			sortedSet = new TreeSet<MyFile>();
		}
		public void traverse(File dir){
		    if (dir.isDirectory()) {
		        String[] children = dir.list();
		        for (String child : children) {
		            traverse(new File(dir, child));
		        }
		    }
		    if (dir.isFile()) {
		    	sortedSet.add(new MyFile( dir.length(),dir.getAbsolutePath() ));
		    }
		}
		public void printSortedFilesList(int num)
		{
			int i=0;
			Iterator<MyFile> iterator =   sortedSet.iterator();
			while (iterator.hasNext() && i<num)
			{
				MyFile tmp_MyFile =  iterator.next();
				System.out.println(tmp_MyFile.getName()+" size:"+tmp_MyFile.getSize());
				i++;
			}
		}
		
}
