package util;

public class MyUtil {
	public static int parseInt(String str) {
		int num = 0;
		try {
			num = Integer.parseInt(str);
		} catch (NumberFormatException e) {
			num = -1;
		}
		return num;
	}
}
