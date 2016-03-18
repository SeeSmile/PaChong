package helpers;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextArea;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;
import com.google.gson.Gson;
import data.CwqEntity;
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
			String result = WebUtil.sendPOST(URL_LOGIN, urlParameters);
			show("登录结果: " + result);
			ArrayList<CwqEntity> list = new ArrayList<CwqEntity>();
			JSONArray jsonArray;
			Gson gson = new Gson();
			for(int i = 1; i < 20; i++) {
				jsonArray = getList(i).optJSONObject("data").optJSONArray("list");
				for(int j = 0; j < jsonArray.length(); j++) {
					list.add(gson.fromJson(jsonArray.getJSONObject(j).toString(), CwqEntity.class));
				}
			}
			show("data:\n" + list.toString());
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
	public String getState() {
		return null;
	}

	private void show(String text) {
		area.append("\n" + text);
		System.out.println(text);
	}

	@Override
	public void getTextArea(JTextArea area) {
		this.area = area;
	}
	
}
