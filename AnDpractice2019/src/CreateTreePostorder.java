/*========================================================================================
 * 
 * Author: Gregory Rozanski
 * 
 * Create a Binary Search Tree from a given Postordering
 * 
 =======================================================================================*/
public class CreateTreePostorder {

	public static void main(String[] args) {
		int[] keys = {8,12,10,16,25,20,15};
		Vertex root = createTree(keys,0,keys.length-1);
		

	}
	static class Vertex{
		int key;
		Vertex left;
		Vertex right;
		public Vertex(int value) {
			this.key = value;
		}
	}
	
	public static Vertex createTree(int[] keys,int left,int right) {
		if(right < left) {
			return null;
		}
		Vertex curr = new Vertex(keys[right]);
		int index = findLeftIndex(keys,curr,left,right);
		curr.right = createTree(keys,index+1,right-1);
		curr.left = createTree(keys,left,index);
		return curr;
	}
	
	public static int findLeftIndex(int[] keys, Vertex curr,int left,int right) {
		for(int i = right; i>=left;i--) {
			if(keys[i] < curr.key) {
				return i;
			}
		}
		return left-1;
	}
}
