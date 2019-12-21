/*=========================================================================================================
 * 
 * Author: Gregory Rozanski
 * 
 * Queue implementation
 * 
 * isEmpty(): returns true if Queue is empty
 * enqueue(Node node): adds node to the end of the queue
 * dequeue(): removes first node of the queue and outputs its value
 * clear(): empties queue
 * printQueue(): outputs contents of the queue from end to beginning
 * 
 =========================================================================================================*/
public class Queue {
	int size;
	Node first;
	Node last;

	public static void main(String[] args) {
		Queue you = new Queue();
		you.enqueue(new Node(5));
		you.enqueue(new Node(13));
		you.enqueue(new Node(1));
		you.enqueue(new Node(2));
		you.enqueue(new Node(8));
		you.enqueue(new Node(11));
		you.printQueue();
		you.dequeue();
		you.dequeue();
		you.printQueue();
		System.out.println(you.size);
		you.enqueue(new Node(0));
		you.printQueue();
		you.clear();
		System.out.println(you.size);

	}

	public Queue() {
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

	public void enqueue(Node node) {
		if (isEmpty()) {
			first = node;
			last = node;
		} else {
			node.next = first;
			first.prev = node;
			first = node;
		}
		size++;
	}

	public void dequeue() {
		System.out.println(last.value);
		last = last.prev;
		last.next = null;
		size--;
	}

	public void printQueue() {
		for (Node i = first; i != null; i = i.next) {
			System.out.print(i.value + " ");
		}
		System.out.println();
	}

	public void clear() {
		size = 0;
		first = null;
		last = null;
	}

	public static class Node {
		int value;
		Node next;
		Node prev;

		public Node(int value) {
			this.value = value;
			this.next = null;
			this.prev = null;
		}
	}
}
