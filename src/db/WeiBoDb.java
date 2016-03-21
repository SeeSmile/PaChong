package db;

import java.sql.SQLException;

import data.CwqEntity;
import data.WeiBoEntity;

public class WeiBoDb extends DBHelper{
	
	private final String TYPE_NAME = "Î¢²¥Ò×";
	
	public void addInfo(WeiBoEntity entity) throws SQLException {
		pst = getPrepared(SQL_INSERT);
		pst.setString(1, entity.getType());
		pst.setString(2, TYPE_NAME);
		pst.setString(3, entity.getWeibo_name());
		pst.setInt(4, Integer.valueOf(entity.getFollowers_count()));
		pst.setString(5, entity.getWeibo_id());
		pst.setString(6, entity.getFace_url());
		pst.setString(7, entity.getScreen_shot_qr_code());
		String top = entity.getGross_deal_price().getSoft_multi_graphic_top_price();
		String second = entity.getGross_deal_price().getSoft_multi_graphic_second_price();
		String other = entity.getGross_deal_price().getSoft_multi_graphic_other_price();
		pst.setFloat(8, getPrice(top));
		pst.setFloat(9, getPrice(second));
		pst.setFloat(10, getPrice(other));
		pst.setString(11, entity.getTime());
		pst.execute();
	}
	
	public float getPrice(String price) {
		float p = 0;
		if(price == null || price.length() == 0) {
			return 0;
		} else {
			p = Float.valueOf(price);
			return p;
		}
		
	}
}
