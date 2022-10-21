package se.kth.id1021.heaps.binarytree;

import java.util.Random;

public class Benchmark_T {
	public static void Benchmarks( int passes ) {
		Heap_T heapT = new Heap_T();
		Integer[] integers = new Integer[ passes * 2 ];
		Integer[] add_index = new Integer[ passes ];
		Integer[] push_index = new Integer[ passes ];

		preparator( passes, integers, heapT );
		for ( int i = 0; i < passes; i++ ) {
			add_index[ i ] = heapT.add( integers[ i ] );
			heapT.remove();
			push_index[ i ] = heapT.push( integers[ i ] );
		}

		int addSum = 0;
		int pushSum = 0;

		for ( int i = 0; i < passes; i++ ) {
			addSum += add_index[ i ];
			pushSum += push_index[ i ];
		}
		System.out.println( "Add depth: " + addSum );
		System.out.println( "Push depth: " + pushSum );
	}

	static void preparator( int passes, Integer[] rnd_index, Heap_T heapT ) {
		for ( int i = 0; i < passes * 2; i++ ) {
			Random rnd = new Random();
			rnd_index[ i ] = rnd.nextInt( passes );
			if ( i < 64 ) {
				heapT.add( rnd.nextInt( passes ) );
			}
		}
	}
}
