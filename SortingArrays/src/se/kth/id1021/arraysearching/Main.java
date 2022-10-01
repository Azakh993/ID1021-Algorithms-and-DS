package se.kth.id1021.arraysearching;

public class Main {
	public static void main( String[] args ) {

		int passes = 100;
		int[] sizes = new int[ 50 ];
		sizes[ 0 ] = 100;
		for ( int i = 1; i < sizes.length; i++ ) {
			sizes[ i ] = sizes[ i - 1 ] + 100;
		}

		Benchmark.Benchmarks( sizes, passes );
	}
}


