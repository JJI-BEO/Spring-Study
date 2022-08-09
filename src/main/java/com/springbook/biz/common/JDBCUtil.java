package com.springbook.biz.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtil {

	public static Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@HYEONM1339_medium?TNS_ADMIN=./Wallet_HYEONM1339", "admin",
					"9711802aS@@!");
			System.out.println("DB 연결 완료");
			return conn;
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC 드라이버 로드 에러");
		} catch (SQLException e) {
			System.out.println("DB연결 오류");
		}
		return null;
	}

	public static void close(PreparedStatement stmt, Connection conn) {

		if (stmt != null) {
			try {
				if (!stmt.isClosed())
					stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				stmt = null;
			}
		}

		if (conn != null) {
			try {
				if (!conn.isClosed())
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				conn = null;
			}
		}

	}

	public static void close(ResultSet rs, PreparedStatement stmt, Connection conn) {

		if (rs != null) {
			try {
				if (!rs.isClosed())
					rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				rs = null;
			}
		}
		if (stmt != null) {
			try {
				if (!stmt.isClosed())
					stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				stmt = null;
			}
		}

		if (conn != null) {
			try {
				if (!conn.isClosed())
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				conn = null;
			}
		}
	}

}
