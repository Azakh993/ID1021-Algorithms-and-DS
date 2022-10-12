package se.kth.id1021.quicksort;

import java.util.Random;

public class Benchmark {
	static void Benchmarks( int[] sizes, int passes ) {
		for ( int size: sizes ) {
			SLL sll = new SLL();
			int[] array = new int[ size ];

			System.out.printf( "%8d", size );

			double ssl_averageTime = Double.POSITIVE_INFINITY;
			double array_averageTime = Double.POSITIVE_INFINITY;

			for ( int i = 0; i < passes; i++ ) {
				preparator( size, sll, array );
				long startTime = System.nanoTime();
				SLL_QS.sort( sll.head, sll.tail );
				long endTime = System.nanoTime();
				double runTime = endTime - startTime;
				if(runTime < ssl_averageTime)
					ssl_averageTime = runTime;
				sll.head.next = sll.tail = null;

				startTime = System.nanoTime();
				Array_QS.sort( array, 0, array.length - 1 );
				endTime = System.nanoTime();
				runTime = endTime - startTime;
				if(runTime < ssl_averageTime)
					array_averageTime = runTime;
			}

			System.out.printf( "%10.0f", ( ssl_averageTime ) );
			System.out.printf( "%10.0f\n", ( array_averageTime ) );
		}
	}

	static void preparator( int size, SLL sll, int[] unsorted_array ) {
		for ( int i = 0; i < size; i++ ) {
			Random rnd = new Random();
			int rnd_int = rnd.nextInt(size*size);
			sll.push( new SLL.Node(rnd_int) );
			unsorted_array[ unsorted_array.length - 1 - i] = rnd_int;
		}
	}
}
