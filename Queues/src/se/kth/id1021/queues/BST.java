package se.kth.id1021.queues;

import java.util.Iterator;
import java.util.Objects;

class BST implements Iterable< Integer > {
	Node root;

	BST() {
		root = null;
	}

	public Iterator< Integer > iterator() {
		return new TreeIterator( root );
	}

	void add( Integer key, Integer value ) {
		root = insert( root, key, value );
	}

	private Node insert( Node root, Integer key, Integer value ) {
		if ( root == null || Objects.equals( root.key, key ) ) {
			root = new Node( key, value );
		} else if ( key > root.key ) {
			root.right = insert( root.right, key, value );
		} else {
			root.left = insert( root.left, key, value );
		}
		return root;
	}

	Integer lookup( Integer key ) {
		return search( root, key ).value;
	}

	Node search( Node root, Integer key ) {
		if ( root == null || Objects.equals( root.key, key ) ) {
			return root;
		} else if ( key > root.key ) {
			return search( root.right, key );
		} else {
			return search( root.left, key );
		}
	}
}
