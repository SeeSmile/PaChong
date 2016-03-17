package data;

import com.google.gson.Gson;

public class CwqEntity {
	/**
	 * 账号名字
	 */
	private String bs_account_name;
	/**
	 * 二维码
	 */
	private String bs_qr_code;
	/**
	 * 头像
	 */
	private String bs_head_img;
	/**
	 * 粉丝数
	 */
	private String pg_fans_num_explain;
	/**
	 * 多图头条
	 */
	private String dtwdyt;
	/**
	 * 多图次条
	 */
	private String dtwdet;
	/**
	 * 多图3_n条
	 */
	private String dtwqtwz;
	
	public String getBs_account_name() {
		return bs_account_name;
	}
	public void setBs_account_name(String bs_account_name) {
		this.bs_account_name = bs_account_name;
	}
	public String getBs_qr_code() {
		return bs_qr_code;
	}
	public void setBs_qr_code(String bs_qr_code) {
		this.bs_qr_code = bs_qr_code;
	}
	public String getBs_head_img() {
		return bs_head_img;
	}
	public void setBs_head_img(String bs_head_img) {
		this.bs_head_img = bs_head_img;
	}
	public String getPg_fans_num_explain() {
		return pg_fans_num_explain;
	}
	public void setPg_fans_num_explain(String pg_fans_num_explain) {
		this.pg_fans_num_explain = pg_fans_num_explain;
	}
	public String getDtwdyt() {
		return dtwdyt;
	}
	public void setDtwdyt(String dtwdyt) {
		this.dtwdyt = dtwdyt;
	}
	public String getDtwdet() {
		return dtwdet;
	}
	public void setDtwdet(String dtwdet) {
		this.dtwdet = dtwdet;
	}
	public String getDtwqtwz() {
		return dtwqtwz;
	}
	public void setDtwqtwz(String dtwqtwz) {
		this.dtwqtwz = dtwqtwz;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return new Gson().toJson(this);
	}
}
