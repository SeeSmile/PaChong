package helpers;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JTextArea;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import data.RuanEntity;
import db.RuanDb;

import urls.Constants;
import urls.PaUrl;
import urls.RuanUrl;

public class RuanHelper extends UrlHelper<PaUrl>{
	
	private final int INDEX_NAME = 1;
	private final int INDEX_URL = 2;
	private final int INDEX_HEI = 4;
	private final int INDEX_NOR = 5;
	private final int INDEX_VIP = 6;

	@Override
	public void doGetData(PaUrl ruanurl) {
		String url = ruanurl.getUrl();
		try {
			showState("���ڻ�ȡ���Ľ����ݡ�����");
			Document doc = Jsoup.connect(url).get();
			Elements eles = doc.getElementsByTag("tbody");
			Elements tds = eles.select("tr");
			RuanEntity entity;
			Elements trs;
			RuanDb db = new RuanDb();
			showState("���������С�����");
			for(Element ele : tds) {
				try {
					entity = new RuanEntity(Constants.TYPE_RUANWEN);
					trs = ele.select("td");
					String name = trs.get(INDEX_NAME).text();
					entity.setName(name);
					if(trs.get(INDEX_URL).hasAttr("a")) {
						entity.setUrl(trs.get(INDEX_URL).select("a").get(0).attr("href"));
					} else {
						entity.setUrl("����");
					}
					entity.setPrice_hei(trs.get(INDEX_HEI).text());
					entity.setPrice_nor(trs.get(INDEX_NOR).text());
					entity.setPrice_vip(trs.get(INDEX_VIP).text());
//					db.addInfo(entity);
					show(entity.toString());
				} catch (Exception e) {
					show("������:" + e.toString());
				}
			}
			showState("��������Ľ����ݵĻ�ȡ��");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
