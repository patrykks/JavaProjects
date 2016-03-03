package edu.agh.jtplab.zad1;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class FileWalker {

    public static void walk( String path ) throws InterruptedException {

        File root = new File( path );
        File[] list = root.listFiles();
        ArrayList<Thread> threads= new ArrayList<Thread>();
        
        if (list == null) return;

        for ( File f : list ) {
            if ( f.isDirectory() ) {
                walk( f.getAbsolutePath() );
            }
            else {
            	threads.add(new Thread(  new FileVisitor(f.getAbsolutePath()) )   );
            	threads.get(threads.size()-1 ).start();
            }
        }
        Iterator <Thread> it = threads.iterator();
        while (it.hasNext())
        {
        	it.next().join();
        }
    }
}