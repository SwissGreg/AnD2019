/*=========================================================================================================
 * Author: Gregory Rozanski
 * 
 * Stack Implementation
 * 
 * Supports following functionality:
 * 
 * isEmpty(): returns true if stack contains no elements
 * top(): outputs value of top element
 * pop(): outputs and removes top element
 * insert(Node node): adds node to the top of the stack
 * clear(): empties stack
 * 
 ========================================================================================================*/
public class Stack {
	int size;
	Node last;
	public static void main(String[] args) {
		Stack stack = new Stack();
		stack.insert(new Node(0));
		stack.insert(new Node(1));
		stack.insert(new Node(2));
		stack.insert(new Node(3));
		stack.insert(new Node(4));
		System.out.println(stack.size);
		stack.pop();
		System.out.println(stack.size);
		stack.top();
		stack.clear();
		System.out.println(stack.size);
	}
	
	public Stack(){
		size = 0;
		last = null;
	}
	public void insert(Node node) {
		if(this.isEmpty()) {
			last = node;
		}else {
			node.prev = last;
			last.next = node;
			last = node;
		}
		size++;
	}
	
	public void top() {
		System.out.println(this.last.value);
	}
	public void pop() {
		System.out.println(this.last.value);
		last = last.prev;
		last.next = null;
		size--;
	}
	
	public void clear() {
		size = 0;
		last = null;
	}
	public boolean isEmpty() {
		if(size == 0) {
			return true;
		}else {
			return false;
		}
	}
	public static class Node{
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
