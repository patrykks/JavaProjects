package edu.agh.jtplab.zad1;

public class MyFile implements Comparable<MyFile> {
	private long size;
	private String name;
	
	public MyFile(long size,String name)
	{
		this.name = name;
		this.size = size;
	}
	public String getName(){
		return name;
	}
	public long getSize()
	{
		return size;
	}
	public void setSize(long size)
	{
		this.size=size;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	@Override
	public int compareTo(MyFile o) {
		// TODO Auto-generated method stub
		if (this.size > o.size) return -1;
		else 
		if (this.size< o.size) return 1;
		else 
		return 0;
	}
}
