package app.logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RevokeDAO {

	private final String DRIVER_NAME = "com.ibm.db2.jcc.DB2Driver";
	private final String JDBC_URL = "jdbc:db2://dashdb-txn-sbox-yp-dal09-03.services.dal.bluemix.net:50000/BLUDB";
	private final String USER = "dcj13621";
	private final String PASS = "rrlb7@tlcx76xdm3";

	public boolean execute(User user) {
		Connection conn = null;
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(JDBC_URL,USER,PASS);
			String sql = "UPDATE user SET flg = '0' WHERE name=? AND pass=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, user.getName());
			pStmt.setString(2, user.getPass());
			int result = pStmt.executeUpdate();

			if (result != 1) {
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
