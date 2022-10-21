package se.kth.id1021.heaps.list;

public class Heap_L_FR {
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
		Node nodeToAdd = new Node( priority );
		Node current = head.next;

		if ( current == null ) {
			head.next = nodeToAdd;
		} else if ( current.priority > nodeToAdd.priority ) {
			nodeToAdd.next = head.next;
			head.next = nodeToAdd;
		} else {
			while ( current.next != null && current.next.priority < nodeToAdd.priority ) {
				current = current.next;
			}

			nodeToAdd.next = current.next;
			current.next = nodeToAdd;
		}
	}

	public Node remove() {
		Node nodeToRemove = head.next;
		head.next = head.next.next;
		return nodeToRemove;
	}
}
