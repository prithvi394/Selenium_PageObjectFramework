package Grp1.HelperClasses;

import java.sql.*;

import org.junit.*;

public class DatabaseHandler {
	Connection con=null;
	Statement stmt;
	String DB_URL="jdbc:mysql://localhost:3306/sql_practice";
	
	
	@Before
	public void setUp() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		String dbClass="com.mysql.jdbc.Driver";
		Class.forName(dbClass).newInstance();
		 con=DriverManager.getConnection(DB_URL, "root", "passw0rd");
		 stmt=con.createStatement();
		
	}
	
	@Test
	public void executeSQL() throws SQLException{
		String query="Select * from sql_practice.masterusrrolelist";
		
		ResultSet rs=stmt.executeQuery(query);
			while (rs.next()){                            
				System. out.println(rs.getString(1)+" | "+rs.getString(2)+" | "+rs.getString(3)+" | "+rs.getString(4)+" | "+rs.getString(5)+" | "+rs.getString(6));
			}
		
	}
	
	

}
