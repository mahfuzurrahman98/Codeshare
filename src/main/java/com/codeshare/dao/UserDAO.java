package com.codeshare.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.codeshare.model.User;
import com.codeshare.service.DBConnection;

public class UserDAO {
	private Connection conn = null;

	public UserDAO() throws IOException {
		conn = DBConnection.getConnection();
	}

	public User checkLogin(String username, String password) {
		User user = null;
		String sql = "select * from Users where Username = ? and Password = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, username);
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				user = new User(
						rs.getInt("Id"),
						rs.getString("Name"),
						rs.getString("Username"),
						rs.getString("Email"),
						rs.getString("CreatedAt"),
						rs.getString("UpdatedAt"),
						rs.getInt("Status"));
			}
		} catch (SQLException e) {
			// System.out.println("DAO Error");
			e.printStackTrace();
		}
		return user;
	}

	public ArrayList<User> getAllUsers(int user_id) {
		ArrayList<User> users = new ArrayList<User>();
		String sql = "select * from Users where Id != ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, user_id);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				users.add(
						new User(rs.getInt("Id"), rs.getString("Name"), rs.getString("Username"), rs.getString("Email"),
								rs.getString("CreatedAt"), rs.getString("UpdatedAt"), rs.getInt("Status")));
			}
		} catch (SQLException e) {
			// System.out.println("DAO Error");
			e.printStackTrace();
		}

		return users;
	}
}
