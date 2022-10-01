package se.kth.id1021.doublylinkedlists;

import java.util.EmptyStackException;

class DLL {

	Node head;

	void push( Node new_Node ) {
		new_Node.next = null;
		new_Node.previous = null;

		if ( head != null ) {
			new_Node.next = head;
			head.previous = new_Node;
		}
		head = new_Node;
	}

	Node remove( Node del_node ) {
		if ( head == null ) {
			throw new EmptyStackException();
		} else if ( del_node == null ) {
			throw new NullPointerException();
		}

		if ( head == del_node ) {
			head = del_node.next;
		}
		if ( del_node.previous != null ) {
			del_node.previous.next = del_node.next;
		}
		if ( del_node.next != null ) {
			del_node.next.previous = del_node.previous;
		}
		return del_node;
	}

	void display() {
		Node next = head;
		System.out.print( "[ " );
		while ( next != null ) {
			System.out.print( next.data + ", " );
			next = next.next;
		}
		System.out.println( "]" );
	}
}
