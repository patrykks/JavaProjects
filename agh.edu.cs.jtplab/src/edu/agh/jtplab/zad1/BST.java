package edu.agh.jtplab.zad1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class BST <T extends Comparable <T> > implements iBST < T> {
	private Node <T> root;
	private static final Logger logger = (Logger) LogManager.getLogger(BST.class.getName());
	
	@Override
	public void insert(T key) {
		// TODO Auto-generated method stub
		if(root == null)
			root = new Node<T>(key);
		else {
			Node<T> actual = root;
			Node<T> parent = null;
			while(actual != null) {
				parent = actual;               
				actual = (actual.getKey().compareTo(key)>0) ? actual.getLeft() : actual.getRight();                 
			}
			if(parent.getKey().compareTo(key) > 0) {
				parent.setLeft(new Node<T>(key));
				parent.getLeft().setParent(parent);
			}
			else {
				parent.setRight(new Node<T>(key));
				parent.getRight().setParent(parent);
			}
	}
	}
	

	@Override
	public Node<T> search(T key) {
		// TODO Auto-generated method stub
		Node<T> actual = root;
		while(actual != null && actual.getKey().compareTo(key) !=0)
		actual = (actual.getKey().compareTo(key) > 0) ? actual.getLeft() : actual.getRight();
		if(actual == null) return null;
		else
		return actual;  
	}

	@Override
	public void inorder() {
		// TODO Auto-generated method stub
		logger.debug("-----------------------InOrder-----------------------");
		inorder_alg(root);
		logger.debug("");
	}
	private void inorder_alg(Node<T> node)
	{
		if(node != null) {
			inorder_alg(node.getLeft());
			logger.debug(node.getKey() + ", ");
			inorder_alg(node.getRight());
		}
	}
	
	@Override
	public void preorder() {
		// TODO Auto-generated method stub
		logger.debug("-----------------------PreOrder-----------------------");
		preorder_alg(root);
		logger.debug("");
	}
	
	private void preorder_alg(Node <T> node) {
		// TODO Auto-generated method stub
		if(node != null) {
			logger.debug(node.getKey() + ", ");
			preorder_alg(node.getLeft());
			preorder_alg(node.getRight());
		}
	}

	@Override
	public void postorder() {
		// TODO Auto-generated method stub
		logger.debug("-----------------------PostOrder-----------------------");
		postorder_alg(root);
		logger.debug("");
	}
	public void postorder_alg(Node<T> node)
	{
		if(node != null) {
			preorder_alg(node.getLeft());
			preorder_alg(node.getRight());
			logger.debug(node.getKey() + ", ");
		}
	}


}
