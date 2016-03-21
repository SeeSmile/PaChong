package helpers;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;
import com.google.gson.Gson;
import data.CwqEntity;
import db.CwqDb;
import urls.Constants;
import urls.PaUrl;
import utils.WebUtil;

public class CwqHelper extends UrlHelper<PaUrl>{
	
	/**
	 * 登录url
	 */
	private final String URL_LOGIN = "http://www.cwq.com/Owner/Account/check_login/";
	
	/**
	 * 获取数据列表url
	 */
	private final String URL_LIST = "http://www.cwq.com/Owner/Weixin/get_weixin_list/";
	
	private final String USER_NAME = "lengzhifu";
	private final String USER_PWD = "wlf2015";
	private int start_page = 0;
	
	/**
	 * 验证码
	 */
	private String code;
	private JTextArea area;

	@Override
	public void doGetData(PaUrl cwqurl) {
		List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
		urlParameters.add(new BasicNameValuePair("account", USER_NAME));
		urlParameters.add(new BasicNameValuePair("password", USER_PWD));
		urlParameters.add(new BasicNameValuePair("verify", code));
		try {
			showState("正在登陆...");
			String result = WebUtil.sendPOST(URL_LOGIN, urlParameters);
			JSONObject json = new JSONObject(result);
			if(json.optString("status").equals("9999")) {
				showState("验证码错误! 请重新获取验证码!");
				return;
			}
			JSONArray jsonArray;
			Gson gson = new Gson();
			CwqEntity entity;
			CwqDb db = new CwqDb();
			showState("正在获取城外圈数据。。。");
			for(int i = start_page; ; i++) {
				show("正在获取城外圈第 " + i + "页信息。");
				jsonArray = getList(i).optJSONObject("data").optJSONArray("list");
				if(jsonArray.length() == 0) {
					break;
				}
				for(int j = 0; j < jsonArray.length(); j++) {
					entity = gson.fromJson(jsonArray.getJSONObject(j).toString(), CwqEntity.class);
					entity.setType(Constants.TYPE_CWQ);
					entity.initTime();
					db.addInfo(entity);
				}
				Thread.sleep(4 * 1000);
			}
		} catch (Exception e) {
			show("报错了:" + e.toString());
		}
	}
	
	private JSONObject getList(int page) throws Exception {
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("is_celebrity", "0"));
		params.add(new BasicNameValuePair("ids", ""));
		params.add(new BasicNameValuePair("order_by", ""));
		params.add(new BasicNameValuePair("all", ""));
		params.add(new BasicNameValuePair("flex", "2"));
		params.add(new BasicNameValuePair("zfjg_type", "2"));
		params.add(new BasicNameValuePair("p", page + ""));
		String result = WebUtil.sendPOST(URL_LIST, params);
		JSONObject jsonObject = new JSONObject(result);
		return jsonObject;
	}
	
	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public void setState(JLabel jl) {
		this.jlb = jl;
	}
	
	public void showState(String text) {
		jlb.setText(text);
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
	
	public void setStartPage(int page) {
		this.start_page = page;
	}
	
}
