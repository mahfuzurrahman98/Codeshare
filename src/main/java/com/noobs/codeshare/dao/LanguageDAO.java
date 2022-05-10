package com.noobs.codeshare.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.xdevapi.Statement;
import com.noobs.codeshare.model.Language;
import com.noobs.codeshare.model.User;
import com.noobs.codeshare.service.DBConnection;

public class LanguageDAO {
	private Connection conn = null;

	public LanguageDAO() throws IOException {
		conn = DBConnection.getConnection();
	}

	public ArrayList<Language> getAllLanguages() {
		ArrayList<Language> list = new ArrayList<Language>();

		String $sql = "select * from Languages order by Name";
		try {
			java.sql.Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery($sql);

			while (rs.next()) {
				list.add(new Language(rs.getInt("Id"), rs.getString("Name")));
			}
		} catch (SQLException e) {
			System.out.println("DAO Error");
			e.printStackTrace();
		}
		return list;

	}
}
