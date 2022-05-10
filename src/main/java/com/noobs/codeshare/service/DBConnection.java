package com.noobs.codeshare.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	private DBConnection() {
	}

	private static Connection conn = null;

	public static Connection getConnection() throws IOException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/Noobs_Codeshare", "root", "Password@9859");
		} catch (Exception e) {
//			e.printStackTrace();
			System.out.println("Db error\n");
		}
		return conn;
	}

}
