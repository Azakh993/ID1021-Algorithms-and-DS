package se.kth.id1021.arraysearching;

import java.util.Random;

class ArrayAlgorithms {
	static int[] unsortedArray( int arraySize ) {
		Random rnd = new Random();
		int[] unsortedArray = new int[ arraySize ];

		for ( int i = 0; i < arraySize; i++ ) {
			unsortedArray[ i ] = rnd.nextInt( arraySize * 10 );
		}

		return unsortedArray;
	}

	static int[] sortedArray( int arraySize ) {
		Random rnd = new Random();
		int[] array = new int[ arraySize ];
		int nextVal = 0;
		for ( int i = 0; i < arraySize; i++ ) {
			nextVal += rnd.nextInt( 10 ) + 1;
			array[ i ] = nextVal;
		}
		return array;
	}
}
