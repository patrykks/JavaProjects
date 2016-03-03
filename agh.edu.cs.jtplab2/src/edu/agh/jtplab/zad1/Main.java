package edu.agh.jtplab.zad1;

import java.io.File;

public class Main {
	public static void main (String [] argv ){
		File file = new File("PAM08");
		FileTraverse fileTraverse = new FileTraverse();
		fileTraverse.traverse(file);
		fileTraverse.printSortedFilesList(50);
	}
}
