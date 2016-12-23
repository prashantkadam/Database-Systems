// usage:  1. compile: javac mydemo1.java
//         2. execute: java mydemo1
import java.sql.*; 
import oracle.jdbc.*;
import java.math.*;
import java.io.*;
import java.awt.*;
import oracle.jdbc.pool.OracleDataSource;

public class mydemo1 {

   public static void main (String args []) throws SQLException {
    try
    {

      //Connecting to Oracle server
      OracleDataSource ds = new oracle.jdbc.pool.OracleDataSource();
      ds.setURL("jdbc:oracle:thin:@castor.cc.binghamton.edu:1521:acad111");
      Connection conn = ds.getConnection("your-userid", "your-password");

      // Create an SQL statement object
      Statement stmt = conn.createStatement (); 

      // Save result after executing the query
	ResultSet rset;
	rset = stmt.executeQuery ("SELECT * FROM students");
    
      // Print the results using a loop
	 // table Students has 6 attributes
      while (rset.next ()) {
         System.out.print (rset.getString (1)+"  ");
         System.out.print (rset.getString (2)+"  ");
	 System.out.print (rset.getString (3)+"  ");
	 System.out.print (rset.getString (4)+"  ");
	 System.out.print (rset.getString (5)+"  ");
	 System.out.println (rset.getString (6)+"  ");
      }

      //Define an update statement and execute it 
      String updateString = "UPDATE students SET status = 'senior' WHERE sid = 'B001'";
      stmt.executeUpdate(updateString);

      // For statements with parameters 
	 // (each ? represents a parameter
      PreparedStatement insert = conn.prepareStatement("INSERT into students VALUES(?,?,?,?,?,?)");
      
      // Input sid from keyboard
      BufferedReader  readKeyBoard; 
	String          sid;
	readKeyBoard = new BufferedReader(new InputStreamReader(System.in)); 
	System.out.print("Please enter SID:");
	sid = readKeyBoard.readLine();
        insert.setString(1, sid);

      // Input other hard-coded values 
        insert.setString(2, "Mark");
        insert.setString(3, "Twin");
	insert.setString(4, "freshman");
	insert.setDouble(5, 3.5);
	insert.setString(6, "mark@bu.edu");

      // execute the insertion
        insert.executeUpdate();

      //Query again to see changed values for the first tuple
	 // and the newly added tuple.
	rset = stmt.executeQuery ("SELECT * FROM students");
    
      // Print
      while (rset.next ()) {
         System.out.print (rset.getString (1)+"  ");
         System.out.print (rset.getString (2)+"  ");
	 System.out.print (rset.getString (3)+"  ");
	 System.out.print (rset.getString (4)+"  ");
	 System.out.print (rset.getString (5)+"  ");
	 System.out.println (rset.getString (6)+"  ");
      }

      //close the result set, statement, and the connection
      rset.close();
      stmt.close();
      conn.close();
   } 
     catch (SQLException ex) { System.out.println ("\n*** SQLException caught ***\n");}
     catch (Exception e) {System.out.println ("\n*** other Exception caught ***\n");}
  }
} 

