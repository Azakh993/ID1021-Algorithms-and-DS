package se.kth.id1021.heaps.binarytree;

public class Node {
	public Integer size;
	public Integer priority;
	public Node left;
	public Node right;

	Node( Integer priority ) {
		this.priority = priority;
		this.size = 0;
	}
}

