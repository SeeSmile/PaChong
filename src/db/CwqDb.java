package db;

import java.sql.SQLException;

import data.CwqEntity;
import data.RuanEntity;

public class CwqDb extends DBHelper {
	
	private final String TYPE_NAME = "≥«Õ‚»¶";
	
	public void addInfo(CwqEntity entity) throws SQLException {
		
		pst = getPrepared(SQL_INSERT);
		pst.setString(1, entity.getType());
		pst.setString(2, TYPE_NAME);
		pst.setString(3, entity.getBs_account_name());
		pst.setInt(4, Integer.valueOf(entity.getBs_fans_num()));
		pst.setString(5, entity.getBs_weixinhao());
		pst.setString(6, entity.getBs_head_img());
		pst.setString(7, entity.getBs_qr_code());
		pst.setFloat(8, Float.valueOf(entity.getDtwdyt()));
		pst.setFloat(9, Float.valueOf(entity.getDtwdet()));
		pst.setFloat(10, Float.valueOf(entity.getDtwqtwz()));
		pst.setString(11, entity.getTime());
		pst.execute();
	}
}
