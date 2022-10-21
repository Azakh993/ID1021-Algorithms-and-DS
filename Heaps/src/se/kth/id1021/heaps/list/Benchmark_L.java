package se.kth.id1021.heaps.list;

import java.util.Random;

public class Benchmark_L {
	public static void Benchmarks( int listSize, int passes ) {
		Heap_L_FA heapLFa = new Heap_L_FA();
		Heap_L_FR heapLFr = new Heap_L_FR();
		Integer[] integers = new Integer[ listSize ];

		System.out.printf( "%8d", listSize );

		double lfa_shortestTime = Double.POSITIVE_INFINITY;
		double lfr_shortestTime = Double.POSITIVE_INFINITY;

		for ( int i = 0; i < passes; i++ ) {
			preparator( listSize, integers );
			long startTime = System.nanoTime();
			for ( int j = 0; j < listSize; j++ ) {
				heapLFa.add( integers[ j ] );
			}
			for ( int j = 0; j < listSize; j++ ) {
				heapLFa.remove();
			}
			long endTime = System.nanoTime();
			double runTime = endTime - startTime;
			if ( runTime < lfa_shortestTime ) {
				lfa_shortestTime = runTime;
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

		System.out.printf( "%10.0f", ( lfa_shortestTime / listSize ) );
		System.out.printf( "%10.0f\n", ( lfr_shortestTime / listSize ) );
	}

	static void preparator( int listSize, Integer[] rnd_index ) {
		for ( int i = 0; i < listSize; i++ ) {
			Random rnd = new Random();
			rnd_index[ i ] = rnd.nextInt( listSize );
		}
	}
}
