package data;

import com.google.gson.Gson;

public class WeiBoEntity {
	/**
	 * 微信名
	 */
	private String weibo_name;
	/**
	 * 粉丝数
	 */
	private String followers_count;
	/**
	 * 微信id
	 */
	private String weibo_id;
	/**
	 * 头像
	 */
	private String face_url;
	/**
	 * 二维码
	 */
	private String screen_shot_qr_code;
	private Price gross_deal_price;
    
    public class Price{
    	/**
    	 * 第一条推广价格
    	 */
		private String soft_multi_graphic_top_price;
		/**
		 * 第二条推广价格
		 */
		private String soft_multi_graphic_second_price;
		/**
		 * 其他推广价格
		 */
		private String soft_multi_graphic_other_price;
		
		@Override
		public String toString() {
			return new Gson().toJson(this);
		}
	}
    
    @Override
    public String toString() {
    	return new Gson().toJson(this);
    }
}
