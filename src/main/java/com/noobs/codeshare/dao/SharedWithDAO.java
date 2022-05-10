package com.noobs.codeshare.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.noobs.codeshare.service.DBConnection;

public class SharedWithDAO {
	private Connection conn = null;

	public SharedWithDAO() throws IOException {
		conn = DBConnection.getConnection();
	}

	public void addSharedWith(int source_id, int shared_user_id) {

		String sql = "insert into Shared_With(Source_Id, Shared_User_Id) VALUES(?, ?)";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, source_id);
			stmt.setInt(2, shared_user_id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			 System.out.println("DAO Error at share with");
			e.printStackTrace();
		}
	}
}