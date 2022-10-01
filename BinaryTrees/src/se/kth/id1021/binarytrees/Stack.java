package se.kth.id1021.binarytrees;

import java.util.EmptyStackException;

class Stack< T > {

	private Node top;

	Stack() {
		top = null;
	}

	void push( T newStackElement ) {
		Node currentTop = top;
		top = new Node( newStackElement );
		top.next = currentTop;
	}

	T pop() {
		if ( top == null ) {
			throw new EmptyStackException();
		}

		T element = top.element;
		top = top.next;
		return element;
	}

	boolean isEmpty() {
		return top == null;
	}

	private class Node {
		T element;
		Node next;

		private Node( T element ) {
			this.element = element;
			next = null;
		}
	}
}
