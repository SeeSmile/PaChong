package data;

import com.google.gson.Gson;

public class WeiBoEntity {
	/**
	 * ΢����
	 */
	private String weibo_name;
	/**
	 * ��˿��
	 */
	private String followers_count;
	/**
	 * ΢��id
	 */
	private String weibo_id;
	/**
	 * ͷ��
	 */
	private String face_url;
	/**
	 * ��ά��
	 */
	private String screen_shot_qr_code;
	private Price gross_deal_price;
    
    public class Price{
    	/**
    	 * ��һ���ƹ�۸�
    	 */
		private String soft_multi_graphic_top_price;
		/**
		 * �ڶ����ƹ�۸�
		 */
		private String soft_multi_graphic_second_price;
		/**
		 * �����ƹ�۸�
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
