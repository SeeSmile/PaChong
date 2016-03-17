package helpers;

import javax.swing.JTextArea;

import urls.PaUrl;

abstract public class UrlHelper<UrlEntity extends PaUrl> {
	public abstract void doGetData(PaUrl paurl);
	public abstract String getState();
	public abstract void getTextArea(JTextArea area);
}
