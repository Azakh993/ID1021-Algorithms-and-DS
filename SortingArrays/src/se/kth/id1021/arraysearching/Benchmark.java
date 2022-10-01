package se.kth.id1021.arraysearching;

import java.util.Random;

public class Benchmark {
	static void Benchmarks( int arraySizes[], int passes ) {
		System.out.printf( "# searching through an array of length n, time in ns\n" );
		System.out.printf( "#%7s%8s%8s%8s\n", "n", "select", "insert", "merge" );
		for ( int arraySize : arraySizes ) {
			System.out.printf( "%8d", arraySize );
			double min = Double.POSITIVE_INFINITY;

			for ( int i = 0; i < passes; i++ ) {
				int[] rnd_array = randomized_array( arraySize );
				long t0 = System.nanoTime();
				SortingAlgorithms.selection_sort( rnd_array );
				long t1 = System.nanoTime();
				double t = ( t1 - t0 );
				if ( t < min ) {
					min = t;
				}
			}

			System.out.printf( "%8.0f", ( min / 1000 ) );

			min = Double.POSITIVE_INFINITY;

			for ( int i = 0; i < passes; i++ ) {
				int[] rnd_array = randomized_array( arraySize );
				long t0 = System.nanoTime();
				SortingAlgorithms.insertion_sort( rnd_array );
				long t1 = System.nanoTime();
				double t = ( t1 - t0 );
				if ( t < min ) {
					min = t;
				}
			}

			System.out.printf( "%8.0f", ( min / 1000 ) );

			min = Double.POSITIVE_INFINITY;

			for ( int i = 0; i < passes; i++ ) {
				int[] rnd_array = randomized_array( arraySize );
				long t0 = System.nanoTime();
				SortingAlgorithms.merge_sort( rnd_array );
				long t1 = System.nanoTime();
				double t = ( t1 - t0 );
				if ( t < min ) {
					min = t;
				}
			}

			System.out.printf( "%8.0f\n", ( min / 1000 ) );
		}
	}

	private static int[] randomized_array( int arraySize ) {
		Random rnd = new Random();
		int[] randomizedArray = new int[ arraySize ];
		for ( int i = 0; i < arraySize; i++ ) {
			randomizedArray[ i ] = rnd.nextInt( arraySize * 10 );
		}
		return randomizedArray;
	}
}
