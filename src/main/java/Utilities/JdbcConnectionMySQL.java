package Utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcConnectionMySQL {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		String host="localhost";
		String port="3306";

		Connection conn=DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/test", "root", "Anurag@210921");
		Statement s=conn.createStatement();
		ResultSet rs=s.executeQuery("SELECT * FROM test.patients\r\n"
				+ "where weight >70");
		
		while(rs.next())
		{
			System.out.println(rs.getString("name"));
		System.out.println(rs.getInt("weight"));
		}
		
	}

}
