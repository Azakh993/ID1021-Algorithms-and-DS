package se.kth.id1021.hashtables.integer;

public class Integer_Benchmark {
	public static void benchmarkInteger( String file, Integer first_zip, Integer second_zip, int passes ) {
		Integer_Zip integer_zip = new Integer_Zip( file );
		double read_average = 0;
		for ( int i = 0; i < passes / 100; i++ ) {
			long t0 = System.nanoTime();
			integer_zip = new Integer_Zip( file );
			long t1 = System.nanoTime();
			double t = ( t1 - t0 );
			read_average += t;
		}

		double binary_average = 0;
		for ( int i = 0; i < passes; i++ ) {
			long t0 = System.nanoTime();
			integer_zip.binary_lookup( first_zip );
			long t1 = System.nanoTime();
			double t = ( t1 - t0 );
			binary_average += t;
		}
		double linear_average = 0;
		for ( int i = 0; i < passes; i++ ) {
			long t0 = System.nanoTime();
			integer_zip.linear_lookup( first_zip );
			long t1 = System.nanoTime();
			double t = ( t1 - t0 );
			linear_average += t;
		}
		System.out.print(
				first_zip + " - Binary: " + ( ( read_average / ( passes / 100 ) ) / 9675 + binary_average ) / passes );
		System.out.println( "\tLinear: " + ( ( read_average / ( passes / 100 ) ) / 9675 + linear_average ) / passes );

		binary_average = 0;
		for ( int i = 0; i < passes; i++ ) {
			long t0 = System.nanoTime();
			integer_zip.binary_lookup( second_zip );
			long t1 = System.nanoTime();
			double t = ( t1 - t0 );
			binary_average += t;
		}
		linear_average = 0;
		for ( int i = 0; i < passes; i++ ) {
			long t0 = System.nanoTime();
			integer_zip.linear_lookup( second_zip );
			long t1 = System.nanoTime();
			double t = ( t1 - t0 );
			linear_average += t;
		}
		System.out.print(
				second_zip + " - Binary: " + ( ( read_average / ( passes / 100 ) ) / 9675 + binary_average ) / passes );
		System.out.println( "\tLinear: " + ( ( read_average / ( passes / 100 ) ) / 9675 + linear_average ) / passes );
	}
}
