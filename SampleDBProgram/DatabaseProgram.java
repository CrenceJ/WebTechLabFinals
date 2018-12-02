/**
 * @(#)DatabaseProgram.java
 *
 *
 * @author Cleverjean Moises A. Comaad
 * @version 1.00 2018/12/1
 * IMPORTANT!!! The mysql driver needs to be added in the jdk to run the program!
 * Can accomplished by going to Configure> Options> JDK Profiles. 
 * Then Click on the JDK version> Edit> Add (In classes tab)> Add archive> Locate driver file> Then OK 
 */
import java.sql.*;
import java.util.*;
public class DatabaseProgram {
    public static void main(String[] args) {
        // TODO code application logic here
        Connection conn = null;
		Statement mystmt = null;
		try
		{
			/* To initiate a connection: conn = ...jdbc:mysql://<url of database>/<schema name>?useSSL=false","<username of database>"
			 *,"<password of database>"); */
			conn = DriverManager.getConnection("jdbc:mysql://localhost/phpmyadmin/test?useSSL=false","root", "");
			mystmt = conn.createStatement();
			
			/* String below (strSelect) is the query statement, gets all data from table 'testdatabase' */
			String strSelect = "select * from testdatabase";
			
			/* Variable rset will execute the statement */
			ResultSet rset = mystmt.executeQuery(strSelect);
			
			/* A loop is required because the value to be returned will be an array or array object..idk. */
			while(rset.next())
			{
				int ID = rset.getInt("ID");
				System.out.println(ID);
			}
		} catch(SQLException ex) 
		{
				ex.printStackTrace();
			}
    }
}
