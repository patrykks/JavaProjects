package edu.agh.jtplab.zad1;

public class Node <T extends Comparable <T> > {
	private T key;
	private Node <T> left,right,parent;
	
	public Node()
	{
		
	}
	public Node(T key)
	{
		this.key = key;
		this.left = null;
		this.right = null;
		this.parent = null;
	}
	public Node(T key,Node <T> left,Node <T> right)
	{
		this.key = key;
		this.left = left;
		this.right = right;
	}
	
	public T getKey()
	{
		return key;
	}
	public void setKey(T key)
	{
		this.key = key;
	}
	public Node <T> getLeft()
	{
		return left;
	}
	public Node <T> getRight()
	{
		return right;
	}
	public void setLeft(Node <T> left)
	{
		this.left = left;
	}
	public void setRight(Node <T> right)
	{
		this.right = right;
	}
	public Node <T> getParent()
	{
		return parent;
	}
	public void setParent(Node <T> parent)
	{
		this.parent = parent;
	}

}
