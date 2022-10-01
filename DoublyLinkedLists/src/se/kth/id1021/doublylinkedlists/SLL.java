package se.kth.id1021.doublylinkedlists;

import java.util.EmptyStackException;

class SLL {

	Node head;

	void push( Node new_Node ) {
		new_Node.next = null;

		if ( head != null ) {
			new_Node.next = head;
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
			head = head.next;
			return del_node;
		}
		Node current = head;
		while ( current != null ) {
			if ( current.next == del_node ) {
				current.next = current.next.next;
				return del_node;
			}
			current = current.next;
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
