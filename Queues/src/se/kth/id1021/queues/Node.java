package se.kth.id1021.queues;

class Node {
	Integer key, value;
	Node left, right;

	Node( Integer key, Integer value ) {
		this.key = key;
		this.value = value;
		left = right = null;
	}
}
