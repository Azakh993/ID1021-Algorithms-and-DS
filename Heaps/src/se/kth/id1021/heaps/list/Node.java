package se.kth.id1021.heaps.list;

class Node {
	int priority;
	Node next;

	Node( int priority ) {
		this.priority = priority;
		this.next = null;
	}

	Node() {
		this.next = null;
	}
}

