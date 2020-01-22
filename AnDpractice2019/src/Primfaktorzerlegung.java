/*==============================================================================
 * 
 * Author: Gregory Rozanski
 * 
 * Eprog HS 2017 Aufgabe 2
 * 
 * Primfaktorzerlegung 
 * 
 * 
 =============================================================================*/
import java.util.ArrayList;
import java.util.List;

public class Primfaktorzerlegung {

	public static void main(String[] args) {
		List<Integer> res = new ArrayList();
		res = primfaktorzerlegung(-36);
		for(int i = 0; i<res.size();i++) {
			System.out.print(res.get(i) + " ");
		}

	}
	public static ArrayList<Integer> primfaktorzerlegung(int n){
		ArrayList<Integer> res = new ArrayList();
		if(n == 0) {
			return res;
		}else if(n<0) {
			res.add(-1);
			n*=-1;
		}else {
			res.add(1);
		}
		while(n > 1) {
			int counter = 2;
			while(n%counter != 0) {
				counter++;
			}
			res.add(counter);
			n/=counter;
		}
		
		return res;
	}
}
