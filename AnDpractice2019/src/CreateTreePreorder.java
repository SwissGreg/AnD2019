/*========================================================================================
 * 
 * Author: Gregory Rozanski
 * 
 * Create a Binary Tree from the preordering
 * 
 =======================================================================================*/
public class CreateTreePreorder {

	static class Vertex {
		int key;
		Vertex left;
		Vertex right;

		public Vertex(int value) {
			this.key = value;
			left = null;
			right = null;
		}

	}

	public static void main(String[] args) {
		int[] keys = { 10, 6, 5, 12, 11, 13 };
		Vertex root = createTree(keys, 0, keys.length - 1);
	}

	public static Vertex createTree(int[] keys, int left, int right) {

		if (left > right) {
			return null;
		}
		Vertex curr = new Vertex(keys[left]);
		int index = findRightIndex(keys, curr, left, right);
		curr.left = createTree(keys, left + 1, index - 1);
		curr.right = createTree(keys, index, right);

		return curr;
	}

	public static int findRightIndex(int[] keys, Vertex curr, int left, int right) {
		for (int i = left; i <= right; i++) {
			if (keys[i] > curr.key) {
				return i;
			}
		}
		return right+1;
	}
}
