package data;

import urls.Constants;

import com.google.gson.Gson;

public class WeiBoEntity extends BaseEntity {
	
	public WeiBoEntity(String type) {
		super(Constants.TYPE_WBY);
	}

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
		
		
		
		public String getSoft_multi_graphic_top_price() {
			return soft_multi_graphic_top_price;
		}



		public void setSoft_multi_graphic_top_price(String soft_multi_graphic_top_price) {
			this.soft_multi_graphic_top_price = soft_multi_graphic_top_price;
		}



		public String getSoft_multi_graphic_second_price() {
			return soft_multi_graphic_second_price;
		}



		public void setSoft_multi_graphic_second_price(
				String soft_multi_graphic_second_price) {
			this.soft_multi_graphic_second_price = soft_multi_graphic_second_price;
		}



		public String getSoft_multi_graphic_other_price() {
			return soft_multi_graphic_other_price;
		}



		public void setSoft_multi_graphic_other_price(
				String soft_multi_graphic_other_price) {
			this.soft_multi_graphic_other_price = soft_multi_graphic_other_price;
		}



		@Override
		public String toString() {
			return new Gson().toJson(this);
		}
	}
    
    
    public String getWeibo_name() {
		return weibo_name;
	}


	public void setWeibo_name(String weibo_name) {
		this.weibo_name = weibo_name;
	}


	public String getFollowers_count() {
		return followers_count;
	}


	public void setFollowers_count(String followers_count) {
		this.followers_count = followers_count;
	}


	public String getWeibo_id() {
		return weibo_id;
	}


	public void setWeibo_id(String weibo_id) {
		this.weibo_id = weibo_id;
	}


	public String getFace_url() {
		return face_url;
	}


	public void setFace_url(String face_url) {
		this.face_url = face_url;
	}


	public String getScreen_shot_qr_code() {
		return screen_shot_qr_code;
	}


	public void setScreen_shot_qr_code(String screen_shot_qr_code) {
		this.screen_shot_qr_code = screen_shot_qr_code;
	}


	public Price getGross_deal_price() {
		return gross_deal_price;
	}


	public void setGross_deal_price(Price gross_deal_price) {
		this.gross_deal_price = gross_deal_price;
	}


	@Override
    public String toString() {
    	return new Gson().toJson(this);
    }
}
