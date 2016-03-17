package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class DBHelper {
	
	public static final String url = "jdbc:mysql://192.168.0.196/media";
	public static final String name = "com.mysql.jdbc.Driver";
	public static final String user = "media";
	public static final String password = "mediamedia";

	public Connection conn = null;
	public PreparedStatement pst = null;

	public DBHelper() {
		try {
			Class.forName(name);//指定连接类型
			conn = DriverManager.getConnection(url, user, password);//获取连接
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public PreparedStatement getPrepared(String sql) throws SQLException {
		pst = conn.prepareStatement(sql);
		return pst;
	}
	
	public void close() {
		try {
			this.conn.close();
			this.pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
