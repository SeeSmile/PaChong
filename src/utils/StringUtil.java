package utils;

public class StringUtil {
	
	/**
	 * ��ȡ�ַ����д�������������
	 * @param result
	 * @return
	 */
	public static String getSimpleString(String result) {
		int p_start = result.indexOf("{");
		int p_end = result.indexOf("}");
		return result.substring(p_start, p_end + 1);
	}
}
