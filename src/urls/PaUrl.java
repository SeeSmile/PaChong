package urls;

import helpers.UrlHelper;

/**
 * 链接的主类
 * @author FuPei
 *
 */
public class PaUrl{
	
	/**
	 * 名字
	 */
	private String name;
	
	/**
	 * 主链接
	 */
	private String url;
	
	/**
	 * 类型
	 */
	private String type;
	
	private UrlHelper<?> helper;
	
	public PaUrl(String name, String url, String type, UrlHelper<?> helper) {
		this.name = name;
		this.url = url;
		this.type = type;
		this.helper = helper;
	}

	
	
	public UrlHelper<?> getHelper() {
		return helper;
	}



	public void setHelper(UrlHelper<?> helper) {
		this.helper = helper;
	}



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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
