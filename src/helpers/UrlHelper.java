package helpers;

import javax.swing.JLabel;
import javax.swing.JTextArea;

import urls.PaUrl;

abstract public class UrlHelper<UrlEntity extends PaUrl> {
	public JLabel jlb;
	public JTextArea area;
	public abstract void doGetData(PaUrl paurl);
	public abstract void setState(JLabel jlb);
	public abstract void getTextArea(JTextArea area);
}
