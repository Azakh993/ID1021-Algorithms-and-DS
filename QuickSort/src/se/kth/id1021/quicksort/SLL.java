package se.kth.id1021.quicksort;

class SLL {
	Node head = new Node();
	Node tail;

	void push( Node newNode ) {

		if ( head.next == null ) {
			tail = head.next = newNode;
		} else {
			newNode.next = head.next;
			head.next = newNode;
		}
	}

	Node pop() {
		Node nodeToPop;
		if ( head.next == null ) {
			return null;
		} else {
			nodeToPop = head.next;
			head.next = head.next.next;
		}
		return nodeToPop;
	}

	void append( Node nodeToAppend ) {
		if ( tail == null ) {
			tail = head.next = nodeToAppend;
		} else {
			tail.next = nodeToAppend;
			tail = tail.next;
		}
	}

	void printList( Node head ) {
		head = head.next;
		System.out.println( "" );
		while ( head != null ) {
			System.out.print( head.data );
			System.out.print( " " );
			head = head.next;
		}
		System.out.println( "" );
	}

	static class Node {
		int data;
		Node next;

		Node( int data ) {
			this.data = data;
			this.next = null;
		}

		Node() {
			this.next = null;
		}
	}
}
