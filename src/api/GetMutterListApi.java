package api;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("getmutterlist")
public class GetMutterListApi {

	private final String DRIVER_NAME = "com.ibm.db2.jcc.DB2Driver";
	private final String JDBC_URL = "jdbc:db2://dashdb-txn-sbox-yp-dal09-03.services.dal.bluemix.net:50000/BLUDB";
	private final String USER = "dcj13621";
	private final String PASS = "rrlb7@tlcx76xdm3";
	private List<ApiMutterDataBean> apiMutterDataBeanList = new ArrayList<ApiMutterDataBean>();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ApiMutterDataBean> doGet(@QueryParam("name") String name) {
		if (name != null) {
			getSingleUsersMutter(name);
		} else {
			getAllUsersMutter();
		}
		return apiMutterDataBeanList;
	}

	public void getSingleUsersMutter(@QueryParam("name") String name) {
		Connection conn = null;

		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(JDBC_URL, USER, PASS);
			String sql = "select * from mutter where name = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, name);

			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				ApiMutterDataBean mutterDataBean = new ApiMutterDataBean();
				mutterDataBean.setName(rs.getString("name"));
				mutterDataBean.setMutter(rs.getString("mutter"));
				mutterDataBean.setTime(rs.getString("time"));
				apiMutterDataBeanList.add(mutterDataBean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void getAllUsersMutter() {
		Connection conn = null;

		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(JDBC_URL, USER, PASS);
			String sql = "select * from mutter";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				ApiMutterDataBean mutterDataBean = new ApiMutterDataBean();
				mutterDataBean.setName(rs.getString("name"));
				mutterDataBean.setMutter(rs.getString("mutter"));
				mutterDataBean.setTime(rs.getString("time"));
				apiMutterDataBeanList.add(mutterDataBean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

}
