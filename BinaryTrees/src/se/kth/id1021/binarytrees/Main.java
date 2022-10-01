package se.kth.id1021.binarytrees;

public class Main {
	public static void main( String[] args ) {
		System.out.printf( "\n%8s%10s%10s\n", "n", "bst", "bsa" );

		int passes = 5000;
		Benchmark.Benchmarks( passes );

/*
		BST tree = new BST();

		tree.add( 50, 50 );
		tree.add( 30, 30 );
		tree.add( 90, 90 );
		tree.add( 40, 40 );
		tree.add( 100, 100 );
		tree.add( 110, 110 );
		tree.add( 70, 70 );
		tree.add( 60, 60 );
		tree.add( 20, 20 );
		tree.add( 80, 80 );

		int counter = 0;

		for ( Integer i : tree ) {
			System.out.println( "Next val: " + i );
			counter++;

			if(counter == 3)
				tree.add( 51, 1010101 );
		}

 */
	}
}


