package se.kth.id1021.binarytrees;

import java.util.Iterator;

public class TreeIterator implements Iterator< Integer > {
	private final Stack< Node > stack = new Stack<>();
	private Node next;

	public TreeIterator( Node root ) {
		traverseLeft( root );
		next = stack.pop();
	}

	private void traverseLeft( Node current ) {
		while ( current != null ) {
			stack.push( current );
			current = current.left;
		}
	}

	@Override public boolean hasNext() {
		return next != null;
	}

	@Override public Integer next() {
		Node current = next;
		if ( current.right != null ) {
			traverseLeft( current.right );
		}
		next = stack.isEmpty() ? null : stack.pop();
		return current.value;
	}
}
