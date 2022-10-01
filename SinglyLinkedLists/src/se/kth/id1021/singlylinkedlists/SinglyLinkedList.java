package se.kth.id1021.singlylinkedlists;

import java.util.EmptyStackException;

class SinglyLinkedList {

	Node head;

	void push( int data ) {
		Node newNode = new Node( data );

		if ( head != null ) {
			newNode.tail = head;
		}
		head = newNode;
	}

	int pop() {
		int data;
		if ( head == null ) {
			throw new EmptyStackException();
		} else {
			data = head.data;
			head = head.tail;
		}
		return data;
	}

	void append( Node node ) {
		if ( head == null ) {
			head = node;
		} else {
			Node last = head;
			while ( last.tail != null ) {
				last = last.tail;
			}
			last.tail = node;
		}
	}

	void remove( int quantity ) {
		Node last = head;

		while ( quantity-- > 1 ) {
			last = last.tail;
		}
		last.tail = null;
	}

	class Node {
		int data;
		Node tail;

		Node( int data ) {
			this.data = data;
			this.tail = null;
		}
	}
}
