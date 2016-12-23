// This program illustrating how to call a PL/SQL stored procedure
import java.sql.*;
import oracle.jdbc.*;
import java.math.*;
import java.io.*;
import java.awt.*;
import oracle.jdbc.pool.OracleDataSource;

public class mydemo2 {

   public static void main (String args []) throws SQLException {
    try
    {

        //Connecting to Oracle server
        OracleDataSource ds = new oracle.jdbc.pool.OracleDataSource();
        ds.setURL("jdbc:oracle:thin:@castor.cc.binghamton.edu:1521:acad111");
        Connection conn = ds.getConnection("your-userid", "your-password");

        // Input sid from keyboard
        BufferedReader  readKeyBoard; 
        String          sid;
        readKeyBoard = new BufferedReader(new InputStreamReader(System.in)); 
        System.out.print("Please Enter SID:");
        sid = readKeyBoard.readLine();

        //Prepare to call stored procedure.
	   //For convenience, the procedure is shown below:
          // procedure show_status (sid_in in students.sid%type, 
          //                     status_out out students.status%type) is
          // begin select status into status_out from students where sid = sid_in;
          // end;
        // :1 and :2 also represent parameter place holders 
	CallableStatement cs = conn.prepareCall("begin show_status(:1,:2); end;");

        //set the in parameter (the first parameter)     
        cs.setString(1, sid);

        //register the out parameter (the second parameter)
        cs.registerOutParameter(2, Types.VARCHAR);

        //execute the stored procedure
        cs.executeQuery();

        //get the out parameter result.
        String status = cs.getString(2);
        System.out.println(sid+" : "+status);
        
        //close the result set, statement, and the connection
        cs.close();
        conn.close();
   } 
   catch (SQLException ex) { System.out.println ("\n*** SQLException caught ***\n" + ex.getMessage());}
   catch (Exception e) {System.out.println ("\n*** other Exception caught ***\n");}
  }
} 


