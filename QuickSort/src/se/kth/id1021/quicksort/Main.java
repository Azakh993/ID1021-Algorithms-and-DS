package se.kth.id1021.quicksort;

public class Main {
	public static void main( String[] args ) {
		System.out.printf( "\n%8s%15s%15s\n", "n", "sll", "dll" );

		int passes = 500;
		int[] sizes = new int[ 30 ];
		sizes[ 0 ] = 50;
		sizes[ 1 ] = 100;
		for ( int i = 2; i < 30; i++ ) {
			sizes[ i ] = 100 + sizes[ i - 1 ];
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