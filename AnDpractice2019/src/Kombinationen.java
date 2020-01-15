/*===========================================================================================================================
 * 
 * Author: Gregory Rozanski
 * 
 * Eprog Basisprüfung fruhjahr 2018 Aufgabe 2
 * Kombinationen
 * 
 ==========================================================================================================================*/

import java.util.*;

public class Kombinationen {

	public static void main(String[] args) {

		System.out.println(generate("12abc"));
	}

	public static String generate(String input) {
		ArrayList<String> arr = new ArrayList();
		String res = "";
		arr.add("");
		generate2(input, arr);
		for (String str : arr) {
			res += " " + "\"" + str + "\"";
		}
		return res.substring(1);

	}

	public static void generate2(String input, ArrayList<String> arr) {
		if (!arr.contains(input)) {
			arr.add(input);
		}
		for (int i = 0; i < input.length(); i++) {
			if (i == 0) {
				generate2(input.substring(1), arr);
			} else {
				generate2(input.substring(0, i) + input.substring(i + 1), arr);
			}
		}

	}
}