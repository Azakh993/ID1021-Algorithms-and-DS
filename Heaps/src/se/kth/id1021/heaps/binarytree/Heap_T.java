package se.kth.id1021.heaps.binarytree;

import java.util.Iterator;

public class Heap_T implements Iterable< Integer > {
	public Node root;

	public Integer add( Integer priority ) {
		Node newNode = new Node( priority );
		Integer depth = 1;

		if ( root == null ) {
			root = newNode;
		} else {
			Node current = root;
			current.size++;

			if ( newNode.priority < current.priority ) {
				Integer temp = newNode.priority;
				newNode.priority = current.priority;
				current.priority = temp;
			}

			while ( current.left != null && current.right != null ) {
				if ( current.left.size <= current.right.size ) {
					current = current.left;
				} else {
					current = current.right;
				}
				if ( newNode.priority < current.priority ) {
					Integer temp = newNode.priority;
					newNode.priority = current.priority;
					current.priority = temp;
				}
				current.size++;
				depth++;
			}

			if ( current.left == null ) {
				current.left = newNode;
			} else {
				current.right = newNode;
			}
			depth++;
		}
		return depth;
	}

	public Integer remove() {
		if ( root == null ) {
			return null;
		}

		Integer valueToReturn = root.priority;

		if ( root.size == 0 ) {
			root = null;
		} else {
			Node current = root;
			Node previous = root;
			current.size--;

			while ( current.left != null && current.right != null ) {
				previous = current;
				if ( current.left.priority < current.right.priority ) {
					current.priority = current.left.priority;
					current = current.left;
				} else {
					current.priority = current.right.priority;
					current = current.right;
				}
				current.size--;
			}

			if ( current.left != null ) {
				current.priority = current.left.priority;
				current.left = null;
			} else if ( current.right != null ) {
				current.priority = current.right.priority;
				current.right = null;
			} else {
				if ( previous.left == current ) {
					previous.left = null;
				} else {
					previous.right = null;
				}
			}
		}
		return valueToReturn;
	}

	public Integer push( Integer increment ) {
		if ( root == null ) {
			return null;
		}

		Integer depth = 1;
		root.priority += increment;

		Node current = root;

		while ( current.left != null && current.right != null ) {
			if ( current.priority > current.right.priority ) {
				Integer temp = current.priority;
				current.priority = current.right.priority;
				current.right.priority = temp;
				current = current.right;
				depth++;
			} else if ( current.priority > current.left.priority ) {
				Integer temp = current.priority;
				current.priority = current.left.priority;
				current.left.priority = temp;
				current = current.left;
				depth++;
			} else {
				break;
			}
		}

		if ( current.left != null && current.priority > current.left.priority ) {
			Integer temp = current.priority;
			current.priority = current.left.priority;
			current.left.priority = temp;
			depth++;
		} else if ( current.right != null && current.priority > current.right.priority ) {
			Integer temp = current.priority;
			current.priority = current.right.priority;
			current.right.priority = temp;
			depth++;
		}

		return depth;
	}

	public Iterator< Integer > iterator() {
		return new TreeIterator( root );
	}
}
