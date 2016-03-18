package data;

public class RuanEntity {
	
	private String name;
	private String url;
	/**
	 * 普通会员
	 */
	private String price_vip;
	/**  
	 * 普通代理
	 */
	private String price_nor;
	/**
	 * 高级代理
	 */
	private String price_hei;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getPrice_hei() {
		return price_hei;
	}
	public void setPrice_hei(String price_hei) {
		this.price_hei = price_hei;
	}
	public String getPrice_vip() {
		return price_vip;
	}
	public void setPrice_vip(String price_vip) {
		this.price_vip = price_vip;
	}
	public String getPrice_nor() {
		return price_nor;
	}
	public void setPrice_nor(String price_nor) {
		this.price_nor = price_nor;
	}
	
	@Override
	public String toString() {
		return "name:" + name +
				", url:" + url + 
				", vip:" + price_vip +
				", hei:" + price_hei +
				", nor:" + price_nor;
	}
	
}
