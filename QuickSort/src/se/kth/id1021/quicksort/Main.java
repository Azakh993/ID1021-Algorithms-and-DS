package se.kth.id1021.quicksort;

public class Main {
	public static void main( String[] args ) {
		System.out.printf( "\n%8s%10s%10s\n", "n", "sll", "dll" );

		int passes = 1000;
		int[] sizes = new int[ 10 ];
		sizes[ 0 ] = 50;
		for ( int i = 1; i < 10; i++ ) {
			sizes[ i ] = 2 * sizes[ i - 1 ];
		}

		Benchmark.Benchmarks( sizes, passes );
		System.out.println();
		Benchmark.Benchmarks( sizes, passes );
		System.out.println();
		Benchmark.Benchmarks( sizes, passes );
		System.out.println();
		Benchmark.Benchmarks( sizes, passes );
		System.out.println();
		Benchmark.Benchmarks( sizes, passes );
		System.out.println();
	}
}