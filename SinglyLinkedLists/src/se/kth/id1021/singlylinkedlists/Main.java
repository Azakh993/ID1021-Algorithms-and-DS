package se.kth.id1021.singlylinkedlists;

public class Main {
	public static void main( String[] args ) {

		System.out.printf( "\n#%7s%8s%8s%8s%8s%8s%8s\n", "n", "A:d+f", "A:f+d", "N:d+f", "N:f+d", "A++", "N++" );


		int passes = 10_000;
		int fixedSize = 1000;
		int dynamicSize = 1000;
		for ( int i = 0; i < 100; i++ ) {
			Benchmark.Benchmarks( fixedSize, dynamicSize, passes );
			dynamicSize += 1000;
		}
	}
}


