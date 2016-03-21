package db;

import java.sql.SQLException;

import data.RuanEntity;

public class RuanDb extends DBHelper {
	private final String TYPE_NAME = "ÈíÎÄ½Ö";
	public void addInfo(RuanEntity entity) throws SQLException {
		System.out.println("time = " + entity.getTime());
		pst = getPrepared(SQL_INSERT);
		pst.setString(1, entity.getType());
		pst.setString(2, TYPE_NAME);
		pst.setString(3, entity.getName());
		pst.setInt(4, 0);
		pst.setString(5, "");
		pst.setString(6, "");
		pst.setString(7, "");
		pst.setFloat(8, toPrice(entity.getPrice_hei()));
		pst.setFloat(9, toPrice(entity.getPrice_nor()));
		pst.setFloat(10, toPrice(entity.getPrice_vip()));
		pst.setString(11, entity.getTime());
		pst.execute();
	}
	
}
