package se.kth.id1021.binarytrees;

public class BinarySearch {
	public static void binarySearch( int[] arr, int first, int last, int key ) {
		int mid = ( first + last ) / 2;
		while ( first <= last ) {
			if ( arr[ mid ] < key ) {
				first = mid + 1;
			} else if ( arr[ mid ] == key ) {
				break;
			} else {
				last = mid - 1;
			}
			mid = ( first + last ) / 2;
		}
		if ( first > last ) {
			System.out.println( "Element is not found!" );
		}
	}
}
