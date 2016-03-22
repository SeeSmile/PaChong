package helpers;

import javax.swing.JLabel;
import javax.swing.JTextArea;

import urls.PaUrl;

abstract public class UrlHelper<UrlEntity extends PaUrl> {
	
	public JLabel jlb;
	public JTextArea area;
	
	/**
	 * ��ȡ΢������
	 * @param paurl
	 */
	public abstract void doGetData(PaUrl paurl);
	
	/**
	 * ��ȡ΢������
	 */
	public void getWeiboData() {
		
	}
	
	/**
	 * ��ȡ΢������Ȧ����
	 */
	public void getWXGroupData() {
		
	}
	
	/**
	 * ��ȡ������Ѷ����
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
	 * ����״̬����ʾ����Ϣ
	 * @param text
	 */
	public void showState(String text) {
		if(jlb == null) {
			return;
		}
		jlb.setText(text);
	}
	
	/**
	 * �������ʾ��Ϣ
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
