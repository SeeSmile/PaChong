package urls;

import helpers.CwqHelper;

public class CwqUrl extends PaUrl{
	
	private final static String NAME = "����Ȧ";
	private final static String URL = "http://www.cwq.com/Owner/Weixin/weixin/";

	public CwqUrl() {
		super(NAME, URL, Constants.TYPE_CWQ, new CwqHelper());
	}
	
}
