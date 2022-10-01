package se.kth.id1021.arraysearching;

import java.util.Random;

class Redundant {
	static void search_unsorted_benchmark( int initialSize, int passes ) {
		int[] randomArray = ArrayAlgorithms.unsortedArray( initialSize );
		int randomKey = new Random().nextInt( initialSize * 10 );

		for ( int k = 1; k < 101; k++ ) {
			long shortest_time = 0;
			int arraySize = initialSize;

			for ( int i = 0; i < passes; i++ ) {
				long startTime = System.nanoTime();
				for ( int j = 0; j < arraySize; j++ ) {
					SearchingAlgorithms.search_unsorted( randomArray, randomKey );
				}
				long endTime = System.nanoTime();

				if ( shortest_time == 0 ) {
					shortest_time = endTime - startTime;
				}

				if ( ( endTime - startTime ) < shortest_time ) {
					shortest_time = endTime - startTime;
				}
			}

			arraySize *= k;
			randomArray = ArrayAlgorithms.unsortedArray( arraySize );
			randomKey = new Random().nextInt( arraySize * 10 );
			System.out.println( "Size: " + arraySize + "\tTime: " + shortest_time );
		}
	}

	static void binary_search_benchmark( int initialSize, int passes ) {
		int[] sortedArray = ArrayAlgorithms.sortedArray( initialSize );
		int randomKey = new Random().nextInt( initialSize * 10 );

		for ( int k = 1; k < 101; k++ ) {
			long shortest_time = 0;
			int arraySize = initialSize;

			for ( int i = 0; i < passes; i++ ) {
				long startTime = System.nanoTime();
				for ( int j = 0; j < arraySize; j++ ) {
					SearchingAlgorithms.binary_search( sortedArray, randomKey );
				}
				long endTime = System.nanoTime();

				if ( shortest_time == 0 ) {
					shortest_time = endTime - startTime;
				}

				if ( ( endTime - startTime ) < shortest_time ) {
					shortest_time += endTime - startTime;
				}
			}

			arraySize *= k;
			sortedArray = ArrayAlgorithms.sortedArray( arraySize );
			randomKey = new Random().nextInt( arraySize * 10 );
			System.out.println( "Size: " + arraySize + "\tTime: " + shortest_time / passes );
		}
	}
}
