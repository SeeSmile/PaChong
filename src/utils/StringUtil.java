package utils;

public class StringUtil {
	
	/**
	 * 获取字符串中大括号里面文字
	 * @param result
	 * @return
	 */
	public static String getSimpleString(String result) {
		int p_start = result.indexOf("{");
		int p_end = result.indexOf("}");
		return result.substring(p_start, p_end + 1);
	}
}
