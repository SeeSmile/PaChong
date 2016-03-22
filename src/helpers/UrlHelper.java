package helpers;

import javax.swing.JLabel;
import javax.swing.JTextArea;

import urls.PaUrl;

abstract public class UrlHelper<UrlEntity extends PaUrl> {
	
	public JLabel jlb;
	public JTextArea area;
	
	/**
	 * 获取微信数据
	 * @param paurl
	 */
	public abstract void doGetData(PaUrl paurl);
	
	/**
	 * 获取微播数据
	 */
	public void getWeiboData() {
		
	}
	
	/**
	 * 获取微信朋友圈数据
	 */
	public void getWXGroupData() {
		
	}
	
	/**
	 * 获取新闻资讯数据
	 */
	public void getAdvsData() {
		
	}
	
	public void setState(JLabel jlb) {
		this.jlb = jlb;
	}
	
	public void getTextArea(JTextArea area) {
		this.area = area;
	}
	
	/**
	 * 设置状态栏显示的信息
	 * @param text
	 */
	public void showState(String text) {
		if(jlb == null) {
			return;
		}
		jlb.setText(text);
	}
	
	/**
	 * 在面板显示信息
	 * @param text
	 */
	public void show(String text) {
		if(area == null) {
			return;
		}
		area.append("\n" + text);
		int length = area.getText().length();
		area.setCaretPosition(length);
	}
}
