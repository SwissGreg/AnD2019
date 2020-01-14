/*===========================================================================================================================
 * 
 * Author: Gregory Rozanski
 * 
 * EPROG Basis Fruhjahr 2018 Exercise 3
 * 
========================================================================================================================== */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class WarenAnalyse {
	
	static void analyse(File input, File output) throws FileNotFoundException {
		Scanner scan = new Scanner(System.in);
		ArrayList<String> names = new ArrayList();
		ArrayList<String> product = new ArrayList();
		ArrayList<Integer> quantity = new ArrayList();
		ArrayList<Double> prices = new ArrayList();
		ArrayList<Double> profit = new ArrayList();
		while(scan.hasNext()) {
			String name = scan.next();
			String pro = scan.next();
			int num = scan.nextInt();
			double price = scan.nextDouble();
			names.add(name);
			product.add(pro);
			quantity.add(num);
			prices.add(price);
			profit.add(num*price);
		}
		System.out.println(one(product,profit,prices));
		System.out.println(two(names,profit));
		System.out.println(three(names,prices));
		
	}
	public static String one(ArrayList<String> product, ArrayList<Double> profit,ArrayList<Double> price) {
		int index = 0;
		double max = 0;
		for(int i = 0; i<product.size();i++) {
			if(profit.get(i) > max) {
				index = i;
				max = profit.get(i);
			}
		}
		return product.get(index) + " " + price.get(index);
		
	}
	public static String two(ArrayList<String> names, ArrayList<Double> profit) {
		double max = 0;
		String result = "";
		for(int i = 0; i<names.size();i++) {
			String temp = names.get(i);
			double curr = profit.get(i);
			for(int j = i+1; j< names.size();j++) {
				if(names.get(j).equals(temp)) {
					curr+=profit.get(j);
				}
			}
			if(curr > max) {
				max = curr;
				result = temp;
			}
		}
		return result + " " + max;
	}
	
	public static String three(ArrayList<String> names, ArrayList<Double> prices) {
		int index = 0;
		double maxDist = 0;
		for(int i = 0; i<names.size();i++) {
			String name = names.get(i);
			double min = Integer.MAX_VALUE;
			double max = Integer.MIN_VALUE;
			for(int j = i+1; j<names.size();j++) {
				if(names.get(j).equals(name)) {
					if(prices.get(j) < min) {
						min = prices.get(j);
					}
					if(prices.get(j) > max) {
						max = prices.get(j);
					}
				}
				
			}
			if(max-min > maxDist) {
				index = i;
				maxDist = max-min;
			}
		}
		return names.get(index);
	}
}
