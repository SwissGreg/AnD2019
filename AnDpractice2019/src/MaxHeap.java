/*=======================================================================================================
 * 
 * Author: Gregory Rozanski
 * 
 * Max Heap implementation using arraylist
 * 
 * indexing starts at 0
 * 
 * supports following functionality:
 * 
 * add(Node node): adds node into the heap
 * swap(Node one,Node two): swaps two nodes in the heap
 * printHeap(): prints the contents of the heap by ascending index
 * extractMax(): outputs and removes the max element and restores the heap condition
 * clear(): empties heap
 =======================================================================================================*/
import java.util.ArrayList;

public class MaxHeap {
	Node root;
	ArrayList<Node> heap;
	int counter;

	public static void main(String[] args) {
		MaxHeap max = new MaxHeap();
		max.add(new Node(15));
		max.printHeap();
		max.add(new Node(4));
		max.printHeap();
		max.add(new Node(1));
		// max.extractMax();
		max.printHeap();
		max.add(new Node(7));
		max.printHeap();
		max.add(new Node(3));
		max.printHeap();
		max.add(new Node(9));
		max.printHeap();
		max.add(new Node(8));
		max.printHeap();
		max.extractMax();
		max.printHeap();
		max.clear();
		max.add(new Node(99));
		System.out.println(max.root.value);
	}

	public MaxHeap() {

		heap = new ArrayList();
		counter = 0;
	}

	public void add(Node node) {
		if (heap.isEmpty()) {
			root = node;
			counter = 1;
			heap.add(node);

		} else if (heap.size() == 1 || heap.size() == 2) {
			heap.add(node);
			if (node.value > root.value) {
				swap(node, root);
				root = node;
			}
		} else {
			heap.add(node);
			counter++;
			while (true) {
				int parentIndex = heap.indexOf(node) / 2;
				int adjusted = 0;
				adjusted = (heap.indexOf(node) % 2 == 1) ? 0 : 1;
				if (parentIndex == 0) {
					adjusted = 0;
				}
				if (heap.indexOf(node) == 0) {
					root = node;
					break;
				}
				if (node.value > heap.get(parentIndex - adjusted).value) {
					swap(node, heap.get(parentIndex - adjusted));
				} else {
					break;
				}
			}

		}

	}

	public void swap(Node one, Node two) {
		int first = heap.indexOf(one);
		int second = heap.indexOf(two);
		Node temp = one;
		heap.set(first, two);
		heap.set(second, temp);
	}

	public void printHeap() {
		for (int i = 0; i < heap.size(); i++) {
			System.out.print(heap.get(i).value + " ");
		}
		System.out.println();
	}

	public void extractMax() {
		if (heap.isEmpty()) {

		} else if (heap.size() == 1) {
			System.out.println(root.value);
			root = null;
			heap.clear();
		} else {
			int counter = 0;
			System.out.println(root.value);
			heap.set(0, heap.get(heap.size() - 1));
			heap.remove(heap.size() - 1);
			root = heap.get(0);
			Node node = root;
			System.out.println(root.value);
			while (true) {
				int left = heap.indexOf(node) * 2 + 1;
				int right = heap.indexOf(node) * 2 + 2;
				if (left > heap.size() - 1) {
					break;
				} else if (right > heap.size() - 1) {
					if (node.value < heap.get(left).value) {
						if (counter == 0) {
							counter = 1;
							root = heap.get(left);
						}
						swap(node, heap.get(left));
					} else {
						break;
					}
				} else {
					if (heap.get(left).value < node.value && heap.get(right).value < node.value) {
						break;
					} else if (heap.get(left).value > node.value && heap.get(right).value < node.value) {
						if (counter == 0) {
							counter = 1;
							root = heap.get(left);
						}
						swap(node, heap.get(left));
					} else if (heap.get(left).value < node.value && heap.get(right).value > node.value) {
						if (counter == 0) {
							counter = 1;
							root = heap.get(right);
						}
						swap(node, heap.get(right));
					} else {
						if (heap.get(left).value > heap.get(right).value) {
							if (counter == 0) {
								counter = 1;
								root = heap.get(left);
							}
							swap(node, heap.get(left));
						} else {
							if (counter == 0) {
								counter = 1;
								root = heap.get(right);
							}
							swap(node, heap.get(right));
						}
					}
				}
			}
		}
	}

	public void clear() {
		heap.clear();
		root = null;
	}

	public static class Node {
		int value;

		public Node(int value) {
			this.value = value;
		}
	}
}
