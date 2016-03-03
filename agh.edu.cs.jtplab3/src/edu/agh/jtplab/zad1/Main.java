package edu.agh.jtplab.zad1;


import java.sql.SQLException;


public class Main {
	public static void main(String [] argv)
	{
		DatabaseConnector databaseConnector = null;
		try{
			databaseConnector = new DatabaseConnector();
			databaseConnector.register();
			databaseConnector.openConnection();
			databaseConnector.createStatement();
			ParseCSV.read("./bookmarks.csv",databaseConnector);
			databaseConnector.readBookmarks();
			//databaseConnector.insertIntoBookmarks(3,"www.interia.pl","category2","second bookmark");
			//databaseConnector.readBookmarks();

		}catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
	   }catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   }
	   try {
		   databaseConnector.closeConnection();
	   } catch (SQLException se)
	   {
		    System.out.println("Error during closing connection ");  
		   se.printStackTrace();
	   }
	   System.out.println("Goodbye!");
	}//end main
}
