/*=============================================================================
 * 
 * Author: Gregory Rozanski
 *
 * Print all possible strings of length k from a set of n characters
 * 
 =============================================================================*/
public class StringFromCharacters {

	public static void main(String[] args) {
		String s = "abc";
		char[] arr = {'a','b','c'};
		generate(arr,3,"");
		
	}
	
	public static void generate(char[] arr, int k,String temp) {
		if(temp.length() == k) {
			System.out.println(temp);
		}else {
			for(int i = 0; i< arr.length;i++) {
				generate(arr,k,temp + "" +arr[i]);
			}
		}
		
	}

}
