package se.kth.id1021.quicksort;

class SLL_QS {
	static void sort( SLL.Node start, SLL.Node end ) {
		if ( start == null || start == end ) {
			return;
		}

		SLL.Node previous_pivot = partitionLast( start, end );
		sort( start, previous_pivot );

		if ( previous_pivot != null && previous_pivot == start ) {
			sort( previous_pivot.next, end );
		} else if ( previous_pivot != null && previous_pivot.next != null ) {
			sort( previous_pivot.next.next, end );
		}
	}

	static SLL.Node partitionLast( SLL.Node start, SLL.Node end ) {
		if ( start.next == end || start.next == null || end == null ) {
			return start;
		}

		SLL.Node pivot = start.next;
		SLL.Node current = start.next.next;
		SLL.Node previous = start.next;
		SLL.Node previous_pivot;
		SLL smaller_sublist = new SLL();


		while ( current != null ) {
			if ( current.data < pivot.data ) {
				previous.next = current.next;
				smaller_sublist.push( current );
				current = previous.next;
			} else {
				previous = previous.next;
				current = current.next;
			}
		}

		if ( smaller_sublist.tail != null ) {
			previous_pivot = smaller_sublist.tail;
			start.next = smaller_sublist.pop();
			smaller_sublist.append( pivot );
		} else {
			previous_pivot = start;
		}

		return previous_pivot;
	}
}
