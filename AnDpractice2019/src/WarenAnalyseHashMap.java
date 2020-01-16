/*==========================================================================================================================
 * 
 * Author: Gregory Rozanski
 * 
 * WarenAnalyse implemented with hash maps
 *   
 =========================================================================================================================*/
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class WarenAnalyseHashMap {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("transaktionen.txt");
		analyse(file, new File("result.txt"));

	}

	public static void analyse(File input, File output) throws FileNotFoundException {
		Scanner scan = new Scanner(input);
		PrintStream out = new PrintStream(output);
		// names of people and profits
		HashMap<String, ArrayList<String>> map1 = new HashMap();
		// names of products and profits
		HashMap<String, ArrayList<String>> map2 = new HashMap();
		while (scan.hasNext()) {
			String product = scan.next();
			String name = scan.next();
			String quantity = scan.next();
			String price = scan.next();
			String profit = "" + (Integer.parseInt(quantity) * Double.parseDouble(price));
			if (!map1.containsKey(product)) {
				ArrayList<String> curr = map1.get(product);
				curr = new ArrayList();
				// index 0 stores the total profit
				curr.add(profit);
				// index 1 stores the largest sale
				curr.add(profit);
				// index 2 stores the price
				curr.add(price);
				// index 3 stores the lowest price, index 4 the highest
				curr.add(price);
				curr.add(price);
				map1.put(product, curr);
			} else {
				// adjust total profit
				double d = Double.parseDouble(map1.get(product).get(0));
				d += Double.parseDouble(profit);
				map1.get(product).set(2, "" + d);
				// adjust largest sale
				d = Double.parseDouble(map1.get(product).get(1));
				if (Double.parseDouble(profit) < d) {
					map1.get(product).set(1, "" + d);
					map1.get(product).set(2, price);
				}
				d = Double.parseDouble(map1.get(product).get(3));
				if (Double.parseDouble(price) < d) {
					map1.get(product).set(3, price);
				}
				d = Double.parseDouble(map1.get(product).get(4));
				if (Double.parseDouble(price) > d) {
					map1.get(product).set(4, price);
				}

			}
			if (!map2.containsKey(name)) {
				ArrayList<String> curr = map1.get(product);
				curr = new ArrayList();
				// index 0 stores the total profit
				curr.add(profit);
				map2.put(name, curr);
			} else {
				double d = Double.parseDouble(map2.get(name).get(0));
				d += Double.parseDouble(profit);
				map2.get(name).set(0, "" + d);

			}
		}
		Set<String> products = map1.keySet();
		Set<String> names = map2.keySet();
		double max = 0;
		String res1 = "";
		double max2 = 0;
		String res2 = "";
		double max3 = 0;
		String res3 = "";
		for (String str : products) {
			double d = Double.parseDouble(map1.get(str).get(1));
			double e = Double.parseDouble(map1.get(str).get(3));
			double f = Double.parseDouble(map1.get(str).get(4));
			if (f - e > max3) {
				max3 = f - e;
				res3 = str;
			}
			if (d > max) {
				max = d;
				res1 = str + " " + map1.get(str).get(2);
			}
		}
		for (String str : names) {
			double d = Double.parseDouble(map2.get(str).get(0));
			if (d > max2) {
				max2 = d;
				res2 = str + " " + max2;
			}
		}
		out.println(res1);
		out.println(res2);
		out.println(res3);

	}
}
