package se.kth.id1021.heaps.binarytree;

class ArrQueue {
	private Node[] queueArray;
	private int size = 4;

	private int front, rear;
	private int elements = 0;

	ArrQueue() {
		front = rear = 0;
		queueArray = new Node[ size ];
	}

	void add( Node newQueueElement ) {
		if ( isFull() ) {
			expandQueue();
		}
		queueArray[ rear ] = newQueueElement;
		rear = ++rear % size;
		elements++;
	}

	boolean isFull() {
		return elements == size;
	}

	void expandQueue() {
		int newSize = size * 2;
		Node[] expandedArray = new Node[ newSize ];
		for ( int i = 0; i < elements; i++ ) {
			expandedArray[ i ] = queueArray[ front ];
			front = ++front % size;
		}
		front = 0;
		rear = elements;
		size = newSize;
		queueArray = expandedArray;
	}

	Node remove() {
		if ( isEmpty() ) {
			return null;
		}
		if ( elements < ( size / 2 ) && size > 4 ) {
			shrinkQueue();
		}
		Node elementToOutput = queueArray[ front ];
		queueArray[ front ] = null;
		front = ++front % size;
		elements--;
		return elementToOutput;
	}

	boolean isEmpty() {
		return elements == 0;
	}

	void shrinkQueue() {
		int newSize = size / 2;
		Node[] shrunkArray = new Node[ newSize ];
		for ( int i = 0; i < elements; i++ ) {
			shrunkArray[ i ] = queueArray[ front ];
			front = ++front % size;
		}
		front = 0;
		rear = elements;
		size = newSize;
		queueArray = shrunkArray;
	}
}
