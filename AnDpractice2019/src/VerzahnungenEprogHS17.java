/*==============================================================================
 * 
 * Author: Gregory Rozanski
 * 
 * Eprog Prüfungsaufgabe 1 HS17 Verzahnungen
 * 
 * find all interleavings of two strings
 * 
 * 
 ==============================================================================*/
import java.util.ArrayList;

public class VerzahnungenEprogHS17 {

	public static void main(String[] args) {
		String s = "12";
		String t = "ab";
		ArrayList<String> res = new ArrayList();
		verzahnungen(s, t, "", res);
		for (int i = 0; i < res.size(); i++) {
			System.out.println(res.get(i));
		}

	}

	public static void verzahnungen(String s, String t, String res, ArrayList<String> arr) {
		if (s.length() == 0) {
			res += t;
			if (!arr.contains(res)) {
				arr.add(res);
			}
		} else if (t.length() == 0) {
			res += s;
			if (!arr.contains(res)) {
				arr.add(res);
			}
		} else {
			verzahnungen(s.substring(1), t, res += s.substring(0, 1), arr);
			res = res.substring(0, res.length() - 1);
			verzahnungen(s, t.substring(1), res += t.substring(0, 1), arr);

		}
	}
}
