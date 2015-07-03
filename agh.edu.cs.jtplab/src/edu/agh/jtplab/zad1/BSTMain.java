package edu.agh.jtplab.zad1;

public class BSTMain {
	public static void main(String [] argv)
	{
		long startTime = System.currentTimeMillis();
		BST<Integer> bst_int = new BST<Integer>();
		BST<String> bst_str = new BST<String>();
		/*
		for (int i=100;i>=0;i--)
		{
			bst_int.insert(i);
			bst_str.insert(Integer.toString(i));
		}
		*/
		//BST INSERT
		bst_int.insert(5);
		bst_str.insert("5");
		bst_int.insert(2);
		bst_str.insert("2");
		bst_int.insert(1);
		bst_str.insert("1");
		bst_int.insert(6);
		bst_str.insert("6");
		bst_int.insert(4);
		bst_str.insert("4");
		bst_int.insert(7);
		bst_str.insert("7");
		// BST VISIT
		bst_int.inorder();
		bst_int.preorder();
		bst_int.postorder();
		bst_str.inorder();
		bst_str.preorder();
		bst_str.postorder();
		long endTime = System.currentTimeMillis();
		System.out.println("End with succes, execution time: " + (endTime - startTime) + " milliseconds");
	}
}
