package se.kth.id1021.queues;

class LLQueue< T > {

	private Node front, rear;

	LLQueue() {
		front = null;
		rear = null;
	}

	void add( T newQueueElement ) {
		Node newNode = new Node(newQueueElement);
		if (isEmpty())
			front = rear =  newNode;
		else {
			rear.next = newNode;
			rear = newNode;
		}
	}

	T remove() {
		if  ( isEmpty() )
			return null;
		Node nodeToRemove = front;
		front = front.next;
		if(front == null)
			rear = null;
		return nodeToRemove.element;
	}

	boolean isEmpty() {
		return front == null;
	}

	private class Node {
		T element;
		Node next;

		private Node( T element ) {
			this.element = element;
			next = null;
		}
	}
}
