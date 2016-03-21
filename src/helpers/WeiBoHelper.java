package helpers;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JTextArea;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.google.gson.Gson;

import data.WeiBoEntity;
import db.WeiBoDb;

import urls.Constants;
import urls.PaUrl;
import utils.WebUtil;

public class WeiBoHelper extends UrlHelper<PaUrl>{
	
	/**
	 * 登录url
	 */
	private final String URL_LOGIN = "http://chuanbo.weiboyi.com/hwauth/index/domainlogin?callback=jQuery18205346484809048689_1458271307341";
	
	private final String URL_TOKEN = "http://chuanbo.weiboyi.com/hworder/weixin";
	/**
	 * 获取数据列表url
	 */
	private final String URL_LIST1 = "http://chuanbo.weiboyi.com/hworder/weixin/filterlist/source/all?";
	private final String URL_LIST2 = "&limit=20&columns=followers_count%2Cgraphic_price_open%2Csoft_graphic_price_open%2Csnbt_exponent%2Ccooperation_degree%2Cread_num%2Cgraphic_send_num";
	private final String USER_NAME = "seesmile";
	private final String USER_PWD = "970782573FP";
	private String key_time;
	private String code;
	private int start_page;

	@Override
	public void doGetData(PaUrl paurl) {
		String param = "&username=" + USER_NAME + "&password=" + USER_PWD + "&captcha=" + code + "&_=" + key_time;
		String result_login;
		try {
			showState("正在登陆微博易...");
			result_login = WebUtil.sendGET(URL_LOGIN + param);
			show("url:\n" + URL_LOGIN + param + "\nresult:\n" + result_login);
			int index_start = result_login.indexOf("{");
			int index_end = result_login.indexOf("}");
			result_login = result_login.substring(index_start, index_end + 1);
			JSONObject json = new JSONObject(result_login);
			if(json.optString("ones").equals("true")) {
				showState("登陆成功！！即刻加载数据...");
				int page = start_page * 20;
				while(true) {
					showState("正在获取第" + (page / 20 + 1) + "页数据");
					try {
						getList(page);
					} catch (Exception e) {
						break;
					}
					page += 20;
				}
			} else {
				showState("验证码错误，请重新输入");
			}
			
		} catch (IOException e1) {
			showState("发生未知错误，请重启！！");
			show(e1.getMessage());
		} catch (JSONException e) {
			showState("发生未知错误，请重启！！");
			show(e.getMessage());
		}
		
	}
	
	private void getList(int page) throws Exception {
		String result = WebUtil.sendGET(URL_TOKEN);
		Document doc = Jsoup.parse(result);
		Element ele = doc.getElementById("web_csrf_token");
		JSONObject json = new JSONObject(WebUtil.sendGET(getListUrl(page, ele.attr("value"))));
		json = json.optJSONObject("data");
		JSONArray array = json.optJSONArray("rows");
		ArrayList<WeiBoEntity> list = new ArrayList<WeiBoEntity>();
		Gson gson = new Gson();
		WeiBoEntity entity;
		WeiBoDb db = new WeiBoDb();
		for(int i = 0; i < array.length(); i++) {
			entity = gson.fromJson(array.getJSONObject(i).optJSONObject("cells").toString(), WeiBoEntity.class);
			entity.setType(Constants.TYPE_WBY);
			entity.initTime();
			list.add(entity);
			db.addInfo(entity);
		}
	}

	@Override
	public void setState(JLabel jl) {
		this.jlb = jl;
	}
	
	private void showState(String text) {
		jlb.setText(text);
	}
	
	private String getListUrl(int page, String token) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(URL_LIST1).append("&web_csrf_token").append(token).append("&start");
		buffer.append(URL_LIST2);
		return buffer.toString();
	}
	
	private void show(String text) {
		area.append("\n" + text);
		int length = area.getText().length();
		area.setCaretPosition(length);
	}

	@Override
	public void getTextArea(JTextArea area) {
		this.area = area;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public void setKeyTime(String key) {
		this.key_time = key;
	}
	
	public void setStartPage(int page) {
		this.start_page = page;
	}

}
