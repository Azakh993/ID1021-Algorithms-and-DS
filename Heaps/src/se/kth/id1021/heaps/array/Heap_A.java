package se.kth.id1021.heaps.array;

import java.util.Arrays;

public class Heap_A {
	private static Integer CAPACITY = null;
	protected Integer[] array;
	protected Integer size;

	public Heap_A( int capacity ) {
		// Java doesn't allow construction of arrays of placeholder data types
		CAPACITY = capacity;
		array = new Integer[ CAPACITY ];
		size = 0;
	}

	public void add( Integer value ) {
		size++;
		Integer index = size;
		array[ index ] = value;
		bubbleUp();
	}

	/**
	 * Performs the "bubble up" operation to place a newly inserted element (i.e. the element that is at the size
	 * index)
	 * in its correct place so that the heap maintains the min-heap order property.
	 */
	protected void bubbleUp() {
		int index = this.size;

		while ( hasParent( index ) && ( parent( index ).compareTo( array[ index ] ) > 0 ) ) {
			// parent/child are out of order; swap them
			swap( index, parentIndex( index ) );
			index = parentIndex( index );
		}
	}

	protected boolean hasParent( Integer i ) {
		return i > 1;
	}

	protected Integer parent( Integer i ) {
		return array[ parentIndex( i ) ];
	}

	protected void swap( int index1, int index2 ) {
		Integer tmp = array[ index1 ];
		array[ index1 ] = array[ index2 ];
		array[ index2 ] = tmp;
	}

	protected int parentIndex( Integer i ) {
		return i / 2;
	}

	/**
	 * Removes and returns the minimum element in the heap.
	 */
	public Integer remove() {
		if ( size == 0 ) {
			return null;
		}

		Integer result = array[ 1 ];

		// get rid of the last leaf/decrement
		array[ 1 ] = array[ size ];
		array[ size ] = null;
		size--;

		bubbleDown();

		return result;
	}

	/**
	 * Performs the "bubble down" operation to place the element that is at the root of the heap in its correct
	 * place so
	 * that the heap maintains the min-heap order property.
	 */
	protected void bubbleDown() {
		int index = 1;

		// bubble down
		while ( hasLeftChild( index ) ) {
			// which of my children is smaller?
			int smallerChild = leftIndex( index );

			// bubble with the smaller child, if I have a smaller child
			if ( hasRightChild( index ) && array[ leftIndex( index ) ].compareTo( array[ rightIndex( index ) ] ) > 0 ) {
				smallerChild = rightIndex( index );
			}

			if ( array[ index ].compareTo( array[ smallerChild ] ) > 0 ) {
				swap( index, smallerChild );
			} else {
				// otherwise, get outta here!
				break;
			}

			// make sure to update loop counter/index of where last el is put
			index = smallerChild;
		}
	}

	protected boolean hasLeftChild( Integer i ) {
		return leftIndex( i ) <= size;
	}

	protected int leftIndex( Integer i ) {
		return i * 2;
	}

	protected boolean hasRightChild( Integer i ) {
		return rightIndex( i ) <= size;
	}

	protected int rightIndex( Integer i ) {
		return i * 2 + 1;
	}

	public String toString() {
		return Arrays.toString( array );
	}
}