package edu.agh.jtplab.zad1;

public interface iBST <T extends Comparable <T> > {
	
	void insert(T key);
	Node<T> search(T key);
	void inorder();
	void preorder();
	void postorder();
	
}
