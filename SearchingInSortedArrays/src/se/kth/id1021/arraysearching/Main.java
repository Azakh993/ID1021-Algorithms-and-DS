package se.kth.id1021.arraysearching;

import java.util.Random;

public class Main {
	public static void main( String[] args ) {

		int[] sizes = new int[ 1 ];
		sizes[ 0 ] = 64_000_000;


		System.out.printf( "# searching through an array of length n, time in ns\n" );
		System.out.printf( "#%7s%8s%8s%8s%8s\n", "n", "linear", "binary", "mbinary", "special" );
		for ( int n : sizes ) {

			int loop = 1000;

			int[] sorted_array = sorted( n );
			int[] sorted_key_array = sorted( n );
			int[] unsorted_key_short = keys( n, n );
			int[] unsorted_key_array = keys( loop, n );

			System.out.printf( "%8d", n );

			int k = 10000;

			double min = Double.POSITIVE_INFINITY;

			for ( int i = 0; i < k; i++ ) {
				long t0 = System.nanoTime();
				linear( sorted_array, unsorted_key_array );
				long t1 = System.nanoTime();
				double t = ( t1 - t0 );
				if ( t < min ) {
					min = t;
				}
			}

			System.out.printf( "%8.0f", ( min / loop ) );


			min = Double.POSITIVE_INFINITY;

			for ( int i = 0; i < k; i++ ) {
				long t0 = System.nanoTime();
				binary( sorted_array, unsorted_key_array );
				long t1 = System.nanoTime();
				double t = ( t1 - t0 );
				if ( t < min ) {
					min = t;
				}
			}

			System.out.printf( "%8.0f", ( min / loop ) );

			min = Double.POSITIVE_INFINITY;

			for ( int i = 0; i < k; i++ ) {
				long t0 = System.nanoTime();
				modified_binary( sorted_array, sorted_key_array, loop );
				long t1 = System.nanoTime();
				double t = ( t1 - t0 );
				if ( t < min ) {
					min = t;
				}
			}

			System.out.printf( "%8.0f", ( min / loop ) );

			min = Double.POSITIVE_INFINITY;

			for ( int i = 0; i < k; i++ ) {
				long t0 = System.nanoTime();
				improved_search( sorted_array, sorted_key_array, loop );
				long t1 = System.nanoTime();
				double t = ( t1 - t0 );
				if ( t < min ) {
					min = t;
				}
			}


			System.out.printf( "%8.0f\n", ( min / loop ) );
		}
	}

	private static int[] sorted( int n ) {
		Random rnd = new Random();
		int[] array = new int[ n ];
		int nxt = rnd.nextInt( 10 );

		for ( int i = 0; i < n; i++ ) {
			array[ i ] = nxt;
			nxt += rnd.nextInt( 10 ) + 1;
		}
		return array;
	}

	private static int[] keys( int loop, int n ) {
		Random rnd = new Random();
		int[] indx = new int[ loop ];
		for ( int i = 0; i < loop; i++ ) {
			indx[ i ] = rnd.nextInt( n * 5 );
		}
		return indx;
	}

	private static void linear( int[] array, int[] indx ) {
		for ( int i = 0; i < indx.length; i++ ) {
			SearchingAlgorithms.search_unsorted( array, indx[ i ] );
		}
	}

	private static void binary( int[] array, int[] indx ) {
		for ( int i = 0; i < indx.length; i++ ) {
			SearchingAlgorithms.binary_search( array, indx[ i ] );
		}
	}

	private static void modified_binary( int[] array, int[] indx, int loops ) {
		for ( int i = 0; i < loops; i++ ) {
			SearchingAlgorithms.array_binary_search( array, indx );
		}
	}

	private static void improved_search( int[] array, int[] indx, int loops ) {
		for ( int i = 0; i < loops; i++ ) {
			SearchingAlgorithms.improved_array_search( array, indx );
		}
	}
}


