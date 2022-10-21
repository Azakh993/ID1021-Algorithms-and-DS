package se.kth.id1021.hashtables.key;

public class Key_Benchmark {
	public static void benchmarkKey( String file, Integer first_zip, Integer second_zip, int passes ) {
		Key_Zip key_zip = new Key_Zip( file );
		double read_average = 0;
		for ( int i = 0; i < passes / 100; i++ ) {
			long t0 = System.nanoTime();
			key_zip = new Key_Zip( file );
			long t1 = System.nanoTime();
			double t = ( t1 - t0 );
			read_average += t;
		}

		double average = 0;
		for ( int i = 0; i < passes; i++ ) {
			long t0 = System.nanoTime();
			key_zip.lookup( first_zip );
			long t1 = System.nanoTime();
			double t = ( t1 - t0 );
			average += t;
		}
		System.out.println(
				first_zip + " - Constant: " + ( ( read_average / ( passes / 100 ) ) / 9675 + average ) / passes );

		average = 0;
		for ( int i = 0; i < passes; i++ ) {
			long t0 = System.nanoTime();
			key_zip.lookup( second_zip );
			long t1 = System.nanoTime();
			double t = ( t1 - t0 );
			average += t;
		}
		System.out.println(
				second_zip + " - Constant: " + ( ( read_average / ( passes / 100 ) ) / 9675 + average ) / passes );
	}
}
