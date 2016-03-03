package edu.agh.jtplab.zad2;

public class DirectedGraph extends Graph {

	public DirectedGraph(int n) {
		super(n);
		// TODO Auto-generated constructor stub
	}
	public void addNewEdge(int x,int y)
	{
		if (x<matrix.length && y<matrix.length)
		{
			matrix[x][y]=1;
		} else 
			System.out.println("Nodes in argument are invalid");
	}

}
