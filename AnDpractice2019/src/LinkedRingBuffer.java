/*==============================================================================
 * 
 * Author: Gregory Rozanski
 * 
 * Linked Ring Buffer Implementation
 * 
 =============================================================================*/
public class LinkedRingBuffer {
	public static void main(String[] args) {
		LinkedRingBuffer buff = new LinkedRingBuffer(2);
		System.out.println(buff.capacity());
	}

	Node first;
	Node last;

	public LinkedRingBuffer(int size) throws IllegalArgumentException {
		if (size < 0) {
			throw new IllegalArgumentException();
		} else {
			Node prev = null;
			for (int i = 0; i < size; i++) {
				Node node = new Node();
				if (i == 0) {
					first = node;
				}
				if (i != 0) {
					prev.next = node;
				}
				prev = node;
				if (i == size - 1) {
					node.next = first;
				}
			}
		}
	}

	public int capacity() {
		int count = 1;
		for (Node i = first; i.next != first; i = i.next) {
			count++;
		}
		return count;
	}

	public int length() {
		if(last == null|| last.value == 0 && first.value== 0 ) {
			return 0;
		}
		int length = 1;
		for(Node i = first; i.next.value != 0;i=i.next) {
			length++;
		}
		if(first == last) {
			return 1;
		}
		return length;
	}

	public void enqueue(int value) throws IllegalStateException {
		if (last == null) {
			first.value = value;
			last = first;
		} else if (this.last.next == first) {
			throw new IllegalStateException();
		} else {
			
			if(first == last && first.value == 0) {
				last = last.next;
				first = last;
			}else {
			last = last.next;
			}
			last.value = value;
		}
	}

	public int dequeue() throws IllegalStateException {
		int value = 0;
		if (last == null) {
			throw new IllegalStateException();
		} else {
			value = first.value;
			if (last == first) {
				first = first.next;
				last = first;
			}else {
			first = first.next;
			}
		}
		return value;
	}
}

class Node {
	Node next;
	int value;
}
