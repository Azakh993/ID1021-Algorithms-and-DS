package se.kth.id1021.hashtables.hashtable;

public class Depth_Hash_Benchmark {
	public static void benchmarkDepth( String file, Integer[] zipCodes, int arraySize ) {
		Better_Hash_Zip better_hash_zip = new Better_Hash_Zip( file, arraySize );
		Hash_Zip hash_zip = new Hash_Zip( file, arraySize );

		double depth = 0;
		for ( Integer zipCode : zipCodes ) {
			depth += hash_zip.lookup( zipCode );
		}

		System.out.println( "Depth: " + depth / zipCodes.length );

		depth = 0;
		for ( Integer zipCode : zipCodes ) {
			depth += better_hash_zip.lookup( zipCode );
		}

		System.out.println( "Better Depth: " + depth / zipCodes.length );
	}
}
