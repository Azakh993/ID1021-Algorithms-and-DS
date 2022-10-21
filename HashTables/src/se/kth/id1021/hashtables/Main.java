package se.kth.id1021.hashtables;

import se.kth.id1021.hashtables.hashtable.Hash_Zip;
import se.kth.id1021.hashtables.integer.Integer_Zip;

import static se.kth.id1021.hashtables.hashtable.Better_Hash_Benchmark.benchmarkBetterHash;
import static se.kth.id1021.hashtables.hashtable.Depth_Hash_Benchmark.benchmarkDepth;
import static se.kth.id1021.hashtables.hashtable.Hash_Benchmark.benchmarkHash;
import static se.kth.id1021.hashtables.integer.Integer_Benchmark.benchmarkInteger;
import static se.kth.id1021.hashtables.key.Key_Benchmark.benchmarkKey;
import static se.kth.id1021.hashtables.string.String_Benchmark.benchmarkString;

public class Main {
	public static void main( String[] args ) {
		String file = "/Users/khz/IdeaProjects/ID1021/HashTables/src/se/kth/id1021/hashtables/zipcodes.csv";
		int passes = 1_000_000;
		int arraySize = 10000;

		Integer_Zip hash_zip = new Integer_Zip( file );
		System.out.println(hash_zip.binary_lookup( 98291 ).getName());
	}

	private static void benchDepth( String file, int arraySize ) {
		Integer_Zip integer_zip = new Integer_Zip( file );
		Integer[] integers = new Integer[ integer_zip.max ];

		for ( int i = 0; i < integers.length; i++ ) {
			integers[ i ] = integer_zip.data[ i ].getZipCode();
		}

		benchmarkDepth( file, integers, arraySize );
	}

	private static void benchmark( String file, int passes, int arraySize ) {
		System.out.println( "\nDepth Lookup Benchmark:" );
		for ( int i = 0; i < 10; i++ ) {
			System.out.println( "Size: " + arraySize );
			benchDepth( file, arraySize );
			arraySize += 5000;
		}

		System.out.println( "\nString Lookup Benchmark:" );
		benchmarkString( file, "111 15", "984 99", passes );

		System.out.println( "\nInteger Lookup Benchmark:" );
		benchmarkInteger( file, 11115, 98499, passes );

		System.out.println( "\nKey Lookup Benchmark:" );
		benchmarkKey( file, 11115, 98499, passes );

		System.out.println( "\nHash Lookup Benchmark:" );
		benchmarkHash( file, 11115, 98499, passes );

		System.out.println( "\nBetter Hash Lookup Benchmark:" );
		benchmarkBetterHash( file, 11115, 98499, passes );
	}
}