package edu.agh.jtplab.zad1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class DatabaseConnector {
	   // JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/TEST";
	   Connection conn = null;
	   Statement stmt = null;
	   
	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "";
	   
	   
	   public void register() throws ClassNotFoundException
	   {
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");
	   }
	   public void openConnection() throws SQLException
	   {
		      //STEP 3: Open a connection
		      System.out.println("Connecting to database...");
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);
	   }
	   public void createStatement() throws SQLException
	   {
		      stmt =  conn.createStatement();
	   }
	   public void readBookmarks() throws SQLException 
	   {
		      //STEP 4: Execute a query
		      System.out.println("Creating statement...");
		      String sql;
		      sql = "SELECT iD,URL,CATEGORY,INFO,ADD_TIME  FROM BOOKMARKS";
		      ResultSet rs = ((java.sql.Statement) stmt).executeQuery(sql);

		      //STEP 5: Extract data from result set
		      while(rs.next()){
		         //Retrieve by column name
		         int id  = rs.getInt("iD");
		         String URL = rs.getString("URL");
		         String CAT = rs.getString("CATEGORY");
		         String INFO = rs.getString("INFO");
		         String TIME = rs.getString("ADD_TIME");

		         
		         //Display values
		         System.out.print("ID: " + id);
		         System.out.print(", URL: " + URL);
		         System.out.print(", Category: " +CAT);
		         System.out.println(", INFO: " + INFO);
		         System.out.println(", Time: " + TIME);
		      }
		      //STEP 6: Clean-up environment
		      rs.close();
	   }
	   public void insertIntoBookmarks(int id,String URL,String category,String info) throws SQLException
	   {
		  java.util.Date date = new Date();
		   String sql = "INSERT INTO BOOKMARKS " +
	                   "VALUES("+id+",'"+URL+"','"+category+"','"+info+"','"+ new java.sql.Timestamp(date.getTime())+"')";
	      System.out.println(sql);
		  stmt.executeUpdate(sql);
	      System.out.println("Inserted records into the table...");
	   }
	   public void closeConnection() throws SQLException
	   {
		   //STEP 6: Clean-up environment
		   if(stmt!=null)
			   stmt.close();
		   if(conn!=null)
			   conn.close();
	   }
	   
}
