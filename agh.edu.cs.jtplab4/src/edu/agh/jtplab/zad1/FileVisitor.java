package edu.agh.jtplab.zad1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.apache.commons.io.FilenameUtils;

public class FileVisitor implements Runnable {
	private String path;
	
	public FileVisitor(String path) {
		this.path = path;
	}
	public enum Ext {
	   txt,doc,docx,html
	}
	private boolean contains(String test) {

	    for (Ext c : Ext.values()) {
	    	if (c.name().equals(test)) {
	            return true;
	        }
	    }

	    return false;
	}
	@Override
	public void run() {
        File text = new File(path);
        String ext = FilenameUtils.getExtension(path);

        if (contains(ext))
        {
        	Scanner scnr = null;
			try {
				scnr = new Scanner(text);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				return;
			}
	        while(scnr.hasNextLine()){
	            String line = scnr.nextLine();
	            if (line.contains("wikimedia")){
	            	System.out.println("Found wikimedia word in"+text.getAbsolutePath());
	                scnr.close();
	            	return;
	            }
	        }
	
	        scnr.close();
        }
	}

}
