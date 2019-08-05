package app.logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {

	private final String DRIVER_NAME = "com.ibm.db2.jcc.DB2Driver";
	private final String JDBC_URL = "jdbc:db2://dashdb-txn-sbox-yp-dal09-03.services.dal.bluemix.net:50000/BLUDB";
	private final String USER = "dcj13621";
	private final String PASS = "rrlb7@tlcx76xdm3";

	public boolean execute(User user) {
		Connection conn = null;
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(JDBC_URL,USER,PASS);
			String sql = "SELECT COUNT(*) AS countuser FROM user WHERE name = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, user.getName());

			ResultSet rs = pStmt.executeQuery();
			rs.next();
			if (rs.getInt("countuser") == 0) {
				return false;
			}
			String sql2 = "SELECT flg FROM user WHERE name = ?";
			PreparedStatement pStmt2 = conn.prepareStatement(sql2);
			pStmt2.setString(1, user.getName());

			ResultSet rs2 = pStmt2.executeQuery();
			rs2.next();
			if (rs2.getInt("flg") == 0) {
				return false;
			}
			String sql3 = "SELECT pass FROM user WHERE name = ?";
			PreparedStatement pStmt3 = conn.prepareStatement(sql3);
			pStmt3.setString(1, user.getName());

			ResultSet rs3 = pStmt3.executeQuery();
			rs3.next();
			if (!rs3.getString("pass").equals(user.getPass())) {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
					return false;
				}
			}
		}
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
