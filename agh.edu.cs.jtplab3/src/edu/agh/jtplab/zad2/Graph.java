package edu.agh.jtplab.zad2;

public abstract class Graph implements iGraph  {
	protected int matrix[][];

	public Graph(int n)
	{
		matrix = new int [n][n];
	}
	public int chceckNodesNumber()
	{
		return matrix[0].length;
	}
	public int checkEdgesNumber(){
		int counter = 0;
		for (int i=0;i<matrix.length;i++)
		{
			for (int j=0;j<matrix.length;j++)
			{
				if (matrix[i][j]>0) counter++;
			}
		}
		return counter;
	}
	public void addNewNode()
	{
		int new_size = matrix.length +1;
		int [][] new_matrix = new int [new_size][new_size];
		for (int i=0;i<matrix.length;i++)
		{
			for (int j=0;j<matrix.length;j++)
			{
				new_matrix[i][j] = matrix [i][j];
			}
		}
		matrix = new_matrix;
	}
	public void addNewEdge(int x,int y)
	{
		if (x<matrix.length && y<matrix.length)
		{
			matrix[x][y]=1;
			matrix[y][x]=1;
		} else 
			System.out.println("Nodes in argument are invalid");
	}
}
