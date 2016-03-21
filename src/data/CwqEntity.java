package data;

import urls.Constants;

import com.google.gson.Gson;

public class CwqEntity extends BaseEntity {
	public CwqEntity(String type) {
		super(Constants.TYPE_CWQ);
	}

	/**
	 * 认证状态
	 */
	private String bs_authenticate_explain;
	/**
	 * 账号名字
	 */
	private String bs_account_name;
	
	private String bs_weixinhao;
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
	private String bs_fans_num;
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
	
	
	public String getBs_weixinhao() {
		return bs_weixinhao;
	}
	public void setBs_weixinhao(String bs_weixinhao) {
		this.bs_weixinhao = bs_weixinhao;
	}
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

	public String getBs_fans_num() {
		return bs_fans_num;
	}
	public void setBs_fans_num(String bs_fans_num) {
		this.bs_fans_num = bs_fans_num;
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
	
	public String getBs_authenticate_explain() {
		return bs_authenticate_explain;
	}
	public void setBs_authenticate_explain(String bs_authenticate_explain) {
		this.bs_authenticate_explain = bs_authenticate_explain;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return new Gson().toJson(this);
	}
}
