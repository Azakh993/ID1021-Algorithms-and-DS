package se.kth.id1021.queues;

import java.util.Iterator;

public class TreeIterator implements Iterator< Integer > {
	// private final LLQueue< Node > queue = new LLQueue<>();
	private final ArrQueue queue = new ArrQueue();


	public TreeIterator( Node root ) {
		queue.add( root );
	}

	@Override public boolean hasNext() {
		return !queue.isEmpty();
	}

	@Override public Integer next() {
		Node elementToOutput = queue.remove();
		if ( elementToOutput.left != null )
			queue.add( elementToOutput.left );
		if ( elementToOutput.right != null)
			queue.add( elementToOutput.right );
		return elementToOutput.value;
	}
}
