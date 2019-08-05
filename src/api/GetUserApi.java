package api;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("getuser")
public class GetUserApi {

	private final String DRIVER_NAME = "com.ibm.db2.jcc.DB2Driver";
	private final String JDBC_URL = "jdbc:db2://dashdb-txn-sbox-yp-dal09-03.services.dal.bluemix.net:50000/BLUDB";
	private final String USER = "dcj13621";
	private final String PASS = "rrlb7@tlcx76xdm3";

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ApiUserDataBean doGet(@QueryParam("name") String name) {
		ApiUserDataBean userDataBean = new ApiUserDataBean();
		Connection conn = null;

		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(JDBC_URL, USER, PASS);
			String sql = "select * from user where name = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, name);

			ResultSet rs = pStmt.executeQuery();
			rs.next();
			userDataBean.setName(rs.getString("name"));
			userDataBean.setPass(rs.getString("pass"));
			if (rs.getInt("flg") == 1) {
				userDataBean.setJotai("有効");
			} else {
				userDataBean.setJotai("無効");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return userDataBean;
	}

}
