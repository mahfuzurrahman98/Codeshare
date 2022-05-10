package com.noobs.codeshare.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Arrays;

import com.noobs.codeshare.model.SourceCode;
import com.noobs.codeshare.service.DBConnection;

public class SourceCodeDAO {
	private Connection conn = null;

	public SourceCodeDAO() throws IOException {
		conn = DBConnection.getConnection();
	}

	public void addSourceCode(int language, int visibility, String source, int created_by, String created_by_alt,
			String created_at, String expire_at, int is_deleted, String[] share_with) throws IOException {
		System.out.println("Exp: " + expire_at + ", creat: " + created_at);
		String sql = "insert into Source_Codes(Language_Id, Visibility, Code, CreatedBy, CreatedByAlt, CreatedAt, ExpireAt, IsDeleted) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, language);
			stmt.setInt(2, visibility);
			stmt.setString(3, source);
			stmt.setInt(4, created_by);
			stmt.setString(5, created_by_alt);
			stmt.setString(6, created_at);
			if (expire_at != null) {
				stmt.setString(7, expire_at);
			} else {
				stmt.setNull(7, Types.NULL);
			}
			stmt.setInt(8, is_deleted);
			int res = stmt.executeUpdate();
			System.out.println("Result: " + res);

			if (visibility == 3) {
				SharedWithDAO shared_with_dao = new SharedWithDAO();
				ResultSet generatedKeys = stmt.getGeneratedKeys();

				if (generatedKeys.next()) {
					int last_inserted_id = generatedKeys.getInt(1);
					for (String user_id : share_with) {
						shared_with_dao.addSharedWith(last_inserted_id, Integer.parseInt(user_id));
					}
				}
			}
		} catch (SQLException e) {
			System.out.println("DAO Error at source code");
			e.printStackTrace();
		}
	}

	public SourceCode getDetailsByID(int id) throws IOException {
		SourceCode details = null;
		String sql = "SELECT Source_Codes.*, Users.Name AS CreatedByName, Languages.Name AS Language, GROUP_CONCAT(Shared_With.Shared_User_Id) AS Shared_Persons FROM Source_Codes JOIN Languages ON Source_Codes.LanguageId = Languages.Id LEFT JOIN Users ON Source_Codes.CreatedBy = Users.Id LEFT JOIN Shared_With ON Source_Codes.Id = Shared_With.Source_Id WHERE Source_Codes.Id = ? GROUP BY Source_Codes.Id";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, id);

			ResultSet rs = stmt.executeQuery();
			rs.next();

			details = new SourceCode(rs.getInt("Id"), rs.getString("Language"), rs.getString("Code"),
					rs.getInt("Visibility"), rs.getInt("createdBy"), rs.getString("createdByName"),
					rs.getString("createdByAlt"),
					Arrays.stream(rs.getString("Shared_Persons").split(",")).mapToInt(Integer::parseInt).toArray(),
					rs.getString("CreatedAt"), rs.getString("ExpireAt"), rs.getInt("IsDeleted"));

		} catch (SQLException e) {
			System.out.println("DAO Error at source code");
			e.printStackTrace();
		}
		return details;
	}
}
