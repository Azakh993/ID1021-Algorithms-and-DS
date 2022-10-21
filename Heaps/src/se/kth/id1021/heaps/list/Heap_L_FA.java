package se.kth.id1021.heaps.list;

public class Heap_L_FA {
	public Node head = new Node();

	public static void printList( Node head ) {
		Node nodeToPrint = head.next;
		System.out.println( "" );
		while ( nodeToPrint.next != null ) {
			System.out.print( nodeToPrint.priority + " " );
			nodeToPrint = nodeToPrint.next;
		}
		System.out.println( "" );
	}

	public void add( int priority ) {
		Node newNode = new Node( priority );
		if ( head.next != null ) {
			newNode.next = head.next;
		}
		head.next = newNode;
	}

	public void remove() {
		Node current = head.next;
		Node previous = head;
		Node nodeToRemove = head.next;

		while ( current.next != null ) {
			if ( current.next.priority < nodeToRemove.priority ) {
				previous = current;
				nodeToRemove = current.next;
			}
			current = current.next;
		}
		previous.next = nodeToRemove.next;
		nodeToRemove.next = null;
	}
}
