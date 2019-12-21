/*=========================================================================================================
 * Author: GREGORY ROZANSKI
 * 
 * AVL-implementation
 ==========================================================================================================*/
public class AVLtree {

	Node root;
	int size;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public AVLtree() {
		size = 0;
		root = null;
	}
	
	public boolean isEmpty() {
		if(this.size == 0) {
			return true;
		}
		return false;
	}
	public void insert(Node node) {
		if(this.isEmpty()) {
			root = node;
		}else {
			
		}
	}
	
	public void delete() {
		
	}
	
	public void leftRotation() {
		
	}
	public void rightRotation() {
		
	}
	public void doubleRotation() {
		
	}
	class Node {
		int value;
		Node left;
		Node right;
		int heightLeft;
		int heightRight;

		public Node(int value) {
			this.value = value;
			left = null;
			right = null;
			heightLeft = 0;
			heightRight = 0;
		}
	}
}
