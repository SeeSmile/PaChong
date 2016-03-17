package urls;

import helpers.RuanHelper;
import helpers.UrlHelper;

public class RuanUrl extends PaUrl {
	
	private final static String NAME = "ÈíÎÄ½Ö";
	private final static String URL = "http://www.ruanwen.la/inc/data.php";

	public RuanUrl() {
		super(NAME, URL, Constants.TYPE_RUANWEN, new RuanHelper());
	}
}
