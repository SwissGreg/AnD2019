/*========================================================================================================
 *Author: Gregory Rozanski 
 *
 *Linked Int List Implementation
 *
 *following functionality defined:
 *
 *isEmpty(): returns true if list contains no elements
 *addLast(Node node): adds node to the end of the list
 *addFirst(Node node): adds node to the beginning of the list
 *insert(Node node, int index): adds node at specified index
 *clear() : empties list
 *removeFirst(): removes first element in the list
 *removeLast(): removes last element in the list
 *remove(int index): removes node at specified index
 *printList(): prints values of nodes in list from beginning to end
 * 
========================================================================================================== */
public class LinkedList {
	Node first;
	Node last;
	int size;

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.addFirst(new Node(0));
		list.addLast(new Node(1));
		list.printList();
		list.insert(new Node(8), 2);
		list.printList();
		list.insert(new Node(7), 2);
		list.printList();
		list.removeFirst();
		list.printList();
		System.out.println(list.size);
		list.removeLast();
		list.printList();
		list.clear();
		System.out.println(list.size);
		System.out.println(list.isEmpty());
	}

	public LinkedList() {
		size = 0;
		first = null;
		last = null;
	}

	public boolean isEmpty() {
		if (size == 0) {
			return true;
		} else {
			return false;
		}
	}

	public void addLast(Node node) {
		if (this.isEmpty()) {
			first = node;
			last = node;
		} else {
			last.next = node;
			last = node;
		}
		size++;
	}

	public void addFirst(Node node) {
		if (this.isEmpty()) {
			first = node;
			last = node;
		} else {
			node.next = first;
			first = node;
		}
		size++;
	}

	public void clear() {
		first = null;
		last = null;
		size = 0;
	}

	public void removeFirst() {
		if (isEmpty()) {

		} else if (size == 1) {
			this.clear();
		} else {
			first = first.next;
		}
		size--;
	}

	public void removeLast() {
		if (isEmpty()) {

		} else if (size == 1) {
			this.clear();
		} else {
			for (Node i = first; i != null; i = i.next) {
				if (i.next == last) {
					last = i;
					i.next = null;
					break;
				}
			}
		}
		size--;
	}

	public void insert(Node node, int index) {
		if (index == 0) {
			this.addFirst(node);
		} else if (index == this.size) {
			this.addLast(node);
		} else {
			Node j = first;
			for (int i = 1; i <= index; i++) {
				if (i == index) {
					node.next = j.next;
					j.next = node;
				}

			}
			size++;
		}

	}

	public void remove(int index) {
		if (index == 0) {
			this.removeFirst();

		} else if (index == this.size - 1) {
			this.removeLast();
		} else {
			Node j = first;
			for (int i = 1; i <= index; i++) {
				if (i == index) {
					j.next = j.next.next;
				}
				j = j.next;
			}
			size--;
		}

	}

	public void printList() {
		for (Node i = first; i != null; i = i.next) {
			System.out.print(i.value + " ");
		}
		System.out.println();
	}

	public static class Node {
		Node next;
		int value;

		public Node(int value) {
			this.value = value;
		}
	}
}
