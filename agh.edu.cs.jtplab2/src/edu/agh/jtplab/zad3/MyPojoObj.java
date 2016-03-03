package edu.agh.jtplab.zad3;

import java.io.Serializable;

public class MyPojoObj implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private String name;
	private int rank;
	public MyPojoObj() {};
	public MyPojoObj(String name,int rank)
	{
		this.name = name;
		this.rank = rank;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public void setRank(int rank)
	{
		this.rank = rank;
	}
	public String getName()
	{
		return name;
	}
	public int getRank()
	{
		return rank;
	}
	public String toString() {
	    return "POJO :" + this.getClass().getName() + " Name :" + this.name + " rank :" + this.rank;
	}

}
