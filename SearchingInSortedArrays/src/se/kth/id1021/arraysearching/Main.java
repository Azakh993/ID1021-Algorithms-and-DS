package se.kth.id1021.arraysearching;

import java.util.Random;

public class Main {
	public static void main(String[] args) {
		System.out.println("Benchmark start:");

		for(int i = 1; i <36; i*=2) {
			benchmark( 1000*i, 10_000 );
		}
	}

	static void benchmark(int arraySize, int passes){
		int[] unsortedArray = new int[ arraySize ];

		Random rnd = new Random();
		int randomKey = rnd.nextInt( arraySize );

		for ( int i = 0; i < arraySize; i++ ) {
			unsortedArray[ i ] = rnd.nextInt( arraySize );
		}

		double averageTime = time( unsortedArray, randomKey, passes );
		averageTime = time(unsortedArray, randomKey, passes);

		System.out.println(
				"Array size: " + arraySize + "\tPasses: " + passes + "\tAverage: " + ( double ) averageTime );
	}

	static double time( int[] array, int key, int passes ) {
		long startAvgTime = System.nanoTime();
		for ( int i = 0; i < passes; i++ ) {
			for ( int j = 0; j < array.length; j++ ) {
				search_unsorted( array, key );
			}
		}
		long endAvgTime = System.nanoTime() - startAvgTime;
		return (double) endAvgTime / passes;
	}

	static boolean search_unsorted( int[] array, int key ) {
		for ( int i : array ) {
			if ( i == key ) {
				return true;
			}
		}
		return false;
	}
}


