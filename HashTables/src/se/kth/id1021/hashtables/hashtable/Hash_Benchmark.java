package se.kth.id1021.hashtables.hashtable;

public class Hash_Benchmark {
	public static void benchmarkHash( String file, Integer first_zip, Integer second_zip, int passes ) {
		Hash_Zip hash_zip = new Hash_Zip( file );
		double read_average = 0;
		for ( int i = 0; i < passes / 100; i++ ) {
			long t0 = System.nanoTime();
			hash_zip = new Hash_Zip( file );
			long t1 = System.nanoTime();
			double t = ( t1 - t0 );
			read_average += t;
		}
		double depth = 0;
		double average = 0;
		for ( int i = 0; i < passes; i++ ) {
			long t0 = System.nanoTime();
			hash_zip.lookup( first_zip );
			long t1 = System.nanoTime();
			double t = ( t1 - t0 );
			average += t;
		}
		System.out.print(
				first_zip + " - Constant: " + ( ( read_average / ( passes / 100 ) ) / 9675 + average ) / passes );
		System.out.println( " Depth: " + depth / passes );

		depth = 0;
		average = 0;
		for ( int i = 0; i < passes; i++ ) {
			long t0 = System.nanoTime();
			hash_zip.lookup( second_zip );
			long t1 = System.nanoTime();
			double t = ( t1 - t0 );
			average += t;
		}
		System.out.print(
				second_zip + " - Constant: " + ( ( read_average / ( passes / 100 ) ) / 9675 + average ) / passes );
		System.out.println( " Depth: " + depth / passes );
	}
}
