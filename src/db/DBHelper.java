package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBHelper {
	
	public static final String ip = "192.168.0.196";
	public static final String url = "jdbc:mysql://" + ip + "/media?characterEncoding=utf8";
	public static final String name = "com.mysql.jdbc.Driver";
	public static final String user = "media";
	public static final String password = "mediamedia";
	public static final String SQL_INSERT = "insert into information (type,type_name,name,fans,weixin_id,url_face,url_code" +
			",price_one,price_two,price_three,info_time) values (?,?,?,?,?,?,?,?,?,?,?)";

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
	
	public Float toPrice(String price) {
		return Float.valueOf(price.substring(0, price.length() - 2));
	}
}
