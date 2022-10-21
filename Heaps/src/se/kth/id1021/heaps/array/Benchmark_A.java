package se.kth.id1021.heaps.array;

import se.kth.id1021.heaps.binarytree.Heap_T;
import se.kth.id1021.heaps.list.Heap_L_FR;

import java.util.Random;

public class Benchmark_A {
	public static void Benchmarks( int listSize, int passes ) {
		Heap_T heapT = new Heap_T();
		Heap_A heapA = new Heap_A( listSize + 2 );
		Heap_L_FR heapLFr = new Heap_L_FR();
		Integer[] integers = new Integer[ listSize ];

		System.out.printf( "%8d", listSize );

		double tree_shortestTime = Double.POSITIVE_INFINITY;
		double array_shortestTime = Double.POSITIVE_INFINITY;
		double lfr_shortestTime = Double.POSITIVE_INFINITY;

		for ( int i = 0; i < passes; i++ ) {
			preparator( listSize, integers );
			long startTime = System.nanoTime();
			for ( int j = 0; j < listSize; j++ ) {
				heapT.add( integers[ j ] );
			}
			for ( int j = 0; j < listSize; j++ ) {
				heapT.remove();
			}
			long endTime = System.nanoTime();
			double runTime = endTime - startTime;
			if ( runTime < tree_shortestTime ) {
				tree_shortestTime = runTime;
			}

			startTime = System.nanoTime();
			for ( int j = 0; j < listSize; j++ ) {
				heapA.add( integers[ j ] );
			}
			for ( int j = 0; j < listSize; j++ ) {
				heapA.remove();
			}
			endTime = System.nanoTime();
			runTime = endTime - startTime;
			if ( runTime < array_shortestTime ) {
				array_shortestTime = runTime;
			}

			startTime = System.nanoTime();
			for ( int j = 0; j < listSize; j++ ) {
				heapLFr.add( integers[ j ] );
			}
			for ( int j = 0; j < listSize; j++ ) {
				heapLFr.remove();
			}
			endTime = System.nanoTime();
			runTime = endTime - startTime;
			if ( runTime < lfr_shortestTime ) {
				lfr_shortestTime = runTime;
			}
		}

		System.out.printf( "%10.0f", ( tree_shortestTime / listSize ) );
		System.out.printf( "%10.0f", ( array_shortestTime / listSize ) );
		System.out.printf( "%10.0f\n", ( lfr_shortestTime / listSize ) );
	}

	static void preparator( int listSize, Integer[] rnd_index ) {
		for ( int i = 0; i < listSize; i++ ) {
			Random rnd = new Random();
			rnd_index[ i ] = rnd.nextInt( listSize );
		}
	}
}
