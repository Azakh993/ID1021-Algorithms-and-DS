package se.kth.id1021.doublylinkedlists;

import java.util.Random;

public class Benchmark {
	static void Benchmarks( int listSize, int operations, int passes ) {
		SLL sll = new SLL();
		DLL dll = new DLL();
		int[] rnd_node_selection = new int[ operations ];

		Node[] nodes = new Node[ listSize ];

		System.out.printf( "%8d", listSize );

		double ssl_shortestTime = Double.POSITIVE_INFINITY;
		double dll_shortestTime = Double.POSITIVE_INFINITY;

		for ( int i = 0; i < passes; i++ ) {
			preparator( listSize, operations, sll, dll, nodes, rnd_node_selection );
			long startTime = System.nanoTime();
			for ( int j = 0; j < operations; j++ ) {
				sll.push( sll.remove( nodes[ rnd_node_selection[ j ] ] ) );
			}
			long endTime = System.nanoTime();
			double runTime = endTime - startTime;
			if ( runTime < ssl_shortestTime ) {
				ssl_shortestTime = runTime;
			}

			startTime = System.nanoTime();
			for ( int j = 0; j < operations; j++ ) {
				dll.push( dll.remove( nodes[ rnd_node_selection[ j ] ] ) );
			}
			endTime = System.nanoTime();
			runTime = endTime - startTime;
			if ( runTime < dll_shortestTime ) {
				dll_shortestTime = runTime;
			}
		}

		System.out.printf( "%10.0f", ( ssl_shortestTime / operations ) );
		System.out.printf( "%10.0f\n", ( dll_shortestTime / operations ) );
	}

	static void preparator( int listSize, int operations, SLL sll, DLL dll, Node[] nodes, int[] rnd_index ) {
		if ( listSize < operations ) {
			for ( int i = 0; i < operations; i++ ) {
				Random rnd = new Random();
				rnd_index[ i ] = rnd.nextInt( listSize );
				if ( i < listSize ) {
					nodes[ i ] = new Node( i );
					sll.push( nodes[ i ] );
					dll.push( nodes[ i ] );
				}
			}
		} else {
			for ( int i = 0; i < listSize; i++ ) {
				Random rnd = new Random();
				nodes[ i ] = new Node( i );
				sll.push( nodes[ i ] );
				dll.push( nodes[ i ] );
				if ( i < operations ) {
					rnd_index[ i ] = rnd.nextInt( listSize );
				}
			}
		}
	}
}
