package se.kth.id1021.arraysearching;

class SortingAlgorithms {
	static void selection_sort( int[] array ) {
		for ( int i = 0; i < array.length - 1; i++ ) {
			int candidate = i;
			for ( int j = i + 1; j < array.length; j++ ) {
				if ( array[ j ] < array[ candidate ] ) {
					candidate = j;
				}
			}

			int smallerNumber = array[ candidate ];
			array[ candidate ] = array[ i ];
			array[ i ] = smallerNumber;
		}
	}

	static void insertion_sort( int[] array ) {
		for ( int i = 1; i < array.length; i++ ) {
			int element = array[ i ];
			int j;

			for ( j = i - 1; j >= 0 && array[ j ] > element; j-- ) {
				array[ j + 1 ] = array[ j ];
			}
			array[ j + 1 ] = element;
		}
	}

	static void merge_sort( int[] array ) {
		if ( array.length == 0 ) {
			return;
		}

		int arraySize = array.length - 1;
		merge_sort_algorithm( array, arraySize );
	}

	private static void merge_sort_algorithm( int[] array, int arraySize ) {
		if ( array.length < 2 ) {
			return;
		}

		int mid = arraySize / 2;
		int[] left_array = new int[ mid ];
		int[] right_array = new int[ arraySize - mid ];

		for ( int i = 0; i < mid; i++ ) {
			left_array[ i ] = array[ i ];
		}
		for ( int i = mid; i < arraySize; i++ ) {
			right_array[ i - mid ] = array[ i ];
		}
		merge_sort_algorithm( left_array, mid );
		merge_sort_algorithm( right_array, arraySize - mid );

		merge( array, left_array, right_array, mid, arraySize - mid );
	}

	private static void merge( int[] array, int[] left_array, int[] right_array, int leftSize, int rightSize ) {

		int leftIndex = 0, rightIndex = 0, arrayIndex = 0;
		while ( leftIndex < leftSize && rightIndex < rightSize ) {
			if ( left_array[ leftIndex ] <= right_array[ rightIndex ] ) {
				array[ arrayIndex++ ] = left_array[ leftIndex++ ];
			} else {
				array[ arrayIndex++ ] = right_array[ rightIndex++ ];
			}
		}

		while ( leftIndex < leftSize ) {
			array[ arrayIndex++ ] = left_array[ leftIndex++ ];
		}

		while ( rightIndex < rightSize ) {
			array[ arrayIndex++ ] = right_array[ rightIndex++ ];
		}
	}
}
