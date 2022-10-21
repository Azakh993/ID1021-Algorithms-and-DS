package se.kth.id1021.queues;

import java.util.Random;

public class Benchmark {
	static void Benchmarks( int loops ) {
		int[] sizes = new int[ 100 ];
		sizes[ 0 ] = 100_000;

		for ( int i = 1; i < 100; i++ ) {
			sizes[ i ] = sizes[ i - 1 ] * 2;
		}


		System.out.print( "# searching through an array of length n, time in ns\n" );
		System.out.printf( "#%12s%12s%12s\n", "n", "bst", "bsa" );
		for ( int size : sizes ) {

			int[] binary_array = new int[ size ];
			int[] random_keys = new int[ size ];
			BST bst = new BST();

			System.out.printf( "%12d", size );

			long t0;
			long t1;
			double tbst = 0;
			double tbsa = 0;

			for ( int i = 0; i < loops; i++ ) {
				preparation( size, random_keys, binary_array, bst );
				for ( int j = 0; j < size; j++ ) {
					t0 = System.nanoTime();
					bst.lookup( random_keys[ j ] );
					t1 = System.nanoTime();
					tbst += ( t1 - t0 );
				}
			}
			System.out.printf( "%12.0f", ( tbst / ( size * loops ) ) );

			for ( int i = 0; i < loops; i++ ) {
				preparation( size, random_keys, binary_array, bst );
				for ( int j = 0; j < size; j++ ) {
					t0 = System.nanoTime();
					t1 = System.nanoTime();
					tbsa += ( t1 - t0 );
				}
			}
			System.out.printf( "%12.0f\n", ( tbsa / ( size * loops ) ) );
		}
	}

	private static void preparation( int size, int[] random_keys, int[] binary_array, BST bst ) {
		bst.root = null;
		Random rnd = new Random();
		int next = rnd.nextInt( 10 );

		for ( int i = 0; i < size; i++ ) {
			random_keys[ i ] = next;
			binary_array[ i ] = next;
			next += rnd.nextInt( 10 ) + 1;
		}

		for ( int i = 0; i < size; i++ ) {
			int randomIndexToSwap = rnd.nextInt( random_keys.length );
			int temp = random_keys[ randomIndexToSwap ];
			random_keys[ randomIndexToSwap ] = random_keys[ i ];
			random_keys[ i ] = temp;
		}

		for ( int i = 0; i < size; i++ ) {
			bst.add( random_keys[ i ], random_keys[ i ] );
		}
	}
}
