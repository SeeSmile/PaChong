package urls;

import helpers.WeiBoHelper;

public class WeiBoUrl extends PaUrl{
	
	private final static String NAME = "Î¢²¥Ò×";
	private final static String URL = "http://www.ruanwen.la/inc/data.php";

	public WeiBoUrl() {
		super(NAME, URL, Constants.TYPE_WBY, new WeiBoHelper());
	}
}
