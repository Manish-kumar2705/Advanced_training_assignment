package com.mycompany.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {

	public static Connection getcon() {
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "password");
			return con;
		}
		catch (Exception e) {
		// TODO: handle exception
			System.out.println(e);
			return null;
		}
	}
}
