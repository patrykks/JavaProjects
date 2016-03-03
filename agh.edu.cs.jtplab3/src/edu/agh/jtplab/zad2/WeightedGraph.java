package edu.agh.jtplab.zad2;

public class WeightedGraph extends Graph {
	
	public WeightedGraph(int n) {
		super(n);
		// TODO Auto-generated constructor stub
	}
	public void addNewEdge(int x,int y,int weight)
	{
		if (x<super.matrix.length && y<super.matrix.length)
		{
			super.matrix[x][y]=weight;
		} else 
			System.out.println("Nodes in argument are invalid");
	}

}
