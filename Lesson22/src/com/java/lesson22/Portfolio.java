
package com.java.lesson22;
import java.sql.*;
/**
 * @author zhumagulov_r
 *
 */
public class Portfolio implements Runnable {

	@Override
	public void run() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null; 
		ResultSetMetaData rsmt = null;
		try {
			conn = DriverManager.getConnection("jdbc:derby://localhost:1527/Lesson22");
			stmt = conn.createStatement();
			String query = "Select * from Portfolio2";
			rs = stmt.executeQuery(query);
			rsmt = rs.getMetaData();
			

			
			
			
			while(rs.next()) {
				
				System.out.println(rs.getInt("id")+ " " +rs.getString("symbol") + " " + rs.getInt("quantity") + " " + rs.getDouble("price") + 
						" Buying power used: " +  rs.getInt("quantity")*rs.getInt("price"));
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			try {
				conn.close();
				stmt.close();
				rs.close();
			} catch (SQLException e) {
				System.out.println(e.getErrorCode());
				
			}
			
		}
		
	}

}
