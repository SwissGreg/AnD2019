/*========================================================================================================
 * Author: Gregory Rozanski
 * 
 * Basic Binary Search Tree implementation
 * 
 * following functions defined:
 * 
 * isEmpty(): returns true if tree is empty
 * insert(Node node): inserts a node into the tree
 * contains(int n): checks if a node in the tree has the value n
 * removeRoot(): removes the root of the tree and replaces it with a suitable node
 * 
 =========================================================================================================*/
public class BinarySearchTree {
	int size;
	Node root;

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(new Node(5));
		System.out.println(tree.root.value);
		tree.insert(new Node(7));
		tree.insert(new Node(3));
		System.out.println(tree.root.left.value);
		System.out.println(tree.root.right.value);
		System.out.println(tree.contains(3));
		System.out.println(tree.contains(89));
		tree.removeRoot();
		System.out.println(tree.root.value);
		tree.removeRoot();
		System.out.println(tree.root.value);
		tree.removeRoot();
		System.out.println(tree.size);
	}

	public BinarySearchTree() {
		size = 0;
		root = null;
	}

	public boolean isEmpty() {
		if (this.size == 0) {
			return true;
		}
		return false;
	}

	public void insert(Node node) {
		if (this.isEmpty()) {
			root = node;
			node.parent = null;
			this.size++;
		} else {
			int val = node.value;
			for (Node i = this.root; i != null;) {
				int curr = i.value;
				if (val < curr) {
					if (i.left == null) {
						i.left = node;
						node.parent = i;
						this.size++;
						break;
					} else {

						i = i.left;
					}
				} else {
					if (i.right == null) {
						i.right = node;
						this.size++;
						node.parent = i;
						break;
					}
					i = i.right;
				}
			}
		}
	}

	public boolean contains(int n) {
		if (this.isEmpty()) {
			return false;
		} else {
			for (Node i = root; i != null;) {
				if (n == i.value) {
					return true;
				} else if (n > i.value) {
					if (i.right == null) {
						return false;
					} else {
						i = i.right;
					}
				} else {
					if (i.left == null) {
						return false;
					} else {
						i = i.left;
					}
				}
			}
		}
		return false;
	}

	public void removeRoot() {
		if (this.isEmpty()) {
			System.out.println("NO ROOT NODE TO REMOVE...");
		} else {
			int v = this.root.value;
			size--;
			System.out.println("REMOVING NODE " + v + "...");
			if (root.left == null && root.right == null) {
				root = null;
				
			} else if (root.right != null) {
				Node node = root.right;
				if (node.left == null) {
					node.left = root.left;
					node.parent = null;
					root = node;
				} else {
					for (Node i = node; i != null;) {
						if (i.left == null) {
							if (root.left != null) {
								i.left = root.left;
							}
							if (i.right != null){
								i.parent.left = i .right;
							}
							i.right = root.right;
							i.parent = null;
							break;
						} else {
							i = i.left;
						}
					}
				}
			} else {
				Node node = root.left;
				if (node.right == null) {
					node.right = root.right;
					node.parent = null;
					root = node;
				} else {
					for (Node i = node; i != null;) {
						if (i.right == null) {
							if (root.right != null) {
								i.right = root.right;
							}
							if(i.left != null) {
								i.parent.right = i.left;
							}
							i.left = root.left;
							i.parent = null;
							break;
						} else {
							i = i.right;
						}
					}
				}
			}
		}
	}

	public static class Node {

		int value;
		Node left;
		Node right;
		Node parent;

		public Node(int value) {
			this.value = value;
			left = null;
			right = null;
			parent = null;
		}
	}
}
