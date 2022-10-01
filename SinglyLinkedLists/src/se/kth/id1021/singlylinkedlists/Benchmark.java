package se.kth.id1021.singlylinkedlists;

public class Benchmark {
	static void Benchmarks( int fixedSize, int dynamicSize, int passes ) {
		SinglyLinkedList linkedList_fixed = new SinglyLinkedList();
		SinglyLinkedList linkedList_dynamic = new SinglyLinkedList();

		int[] array_fixed = new int[ fixedSize ];
		int[] array_dynamic = new int[ dynamicSize ];
		int totalSize = fixedSize + dynamicSize;

		dataGenerator( fixedSize, dynamicSize, linkedList_fixed, linkedList_dynamic, array_fixed, array_dynamic );

		System.out.printf( "%8d", dynamicSize );

		double min = Double.POSITIVE_INFINITY;
		for ( int i = 0; i < passes * 2; i++ ) {
			long t0 = System.nanoTime();
			int[] array_large = new int[ totalSize ];
			for ( int j = 0; j < totalSize; j++ ) {
				if ( j < dynamicSize ) {
					array_large[ j ] = array_dynamic[ j ];
				} else {
					array_large[ j ] = array_fixed[ j - dynamicSize ];
				}
			}
			long t1 = System.nanoTime();
			double t = ( t1 - t0 );
			if ( t < min ) {
				min = t;
			}
		}

		for ( int i = 0; i < passes; i++ ) {
			long t0 = System.nanoTime();
			int[] array_large = new int[ totalSize ];
			for ( int j = 0; j < totalSize; j++ ) {
				if ( j < dynamicSize ) {
					array_large[ j ] = array_dynamic[ j ];
				} else {
					array_large[ j ] = array_fixed[ j - dynamicSize ];
				}
			}
			long t1 = System.nanoTime();
			double t = ( t1 - t0 );
			if ( t < min ) {
				min = t;
			}
		}
		System.out.printf( "%8.0f", ( min ) );

		min = Double.POSITIVE_INFINITY;
		for ( int i = 0; i < passes; i++ ) {
			long t0 = System.nanoTime();
			int[] array_large = new int[ totalSize ];
			for ( int j = 0; j < totalSize; j++ ) {
				if ( j < fixedSize ) {
					array_large[ j ] = array_fixed[ j ];
				} else {
					array_large[ j ] = array_dynamic[ j - fixedSize ];
				}
			}
			long t1 = System.nanoTime();
			double t = ( t1 - t0 );
			if ( t < min ) {
				min = t;
			}
		}
		System.out.printf( "%8.0f", ( min ) );

		min = Double.POSITIVE_INFINITY;
		for ( int i = 0; i < passes; i++ ) {
			long t0 = System.nanoTime();
			linkedList_dynamic.append( linkedList_fixed.head );
			long t1 = System.nanoTime();
			double t = ( t1 - t0 );
			if ( t < min ) {
				min = t;
			}
			linkedList_dynamic.remove( dynamicSize );
		}
		System.out.printf( "%8.0f", ( min ) );

		min = Double.POSITIVE_INFINITY;
		for ( int i = 0; i < passes; i++ ) {
			long t0 = System.nanoTime();
			linkedList_fixed.append( linkedList_dynamic.head );
			long t1 = System.nanoTime();
			double t = ( t1 - t0 );
			if ( t < min ) {
				min = t;
			}
			linkedList_fixed.remove( fixedSize );
		}
		System.out.printf( "%8.0f", ( min ) );


		min = Double.POSITIVE_INFINITY;
		for ( int i = 0; i < passes; i++ ) {
			long t0 = System.nanoTime();
			int[] newArray = new int[ dynamicSize ];
			for ( int j = 0; j < dynamicSize; j++ ) {
				newArray[ j ] = j;
			}
			long t1 = System.nanoTime();
			double t = ( t1 - t0 );
			if ( t < min ) {
				min = t;
			}
		}
		System.out.printf( "%8.0f", ( min ) );

		min = Double.POSITIVE_INFINITY;
		for ( int i = 0; i < passes; i++ ) {
			long t0 = System.nanoTime();
			SinglyLinkedList newLinkedList = new SinglyLinkedList();
			for ( int j = 0; j < dynamicSize; j++ ) {
				newLinkedList.push( j );
			}
			long t1 = System.nanoTime();
			double t = ( t1 - t0 );
			if ( t < min ) {
				min = t;
			}
		}
		System.out.printf( "%8.0f\n", ( min ) );
	}

	private static void dataGenerator( int fixedSize, int dynamicSize, SinglyLinkedList linkedList_fixed,
	                                   SinglyLinkedList linkedlList_dynamic, int[] array_fixed, int[] array_dynamic ) {
		if ( fixedSize > dynamicSize ) {
			for ( int i = 1; i < fixedSize + 1; i++ ) {
				linkedList_fixed.push( i );
				array_fixed[ i - 1 ] = i;

				if ( i < dynamicSize ) {
					linkedlList_dynamic.push( i );
					array_dynamic[ i - 1 ] = i;
				}
			}
		} else {
			for ( int i = 1; i < dynamicSize + 1; i++ ) {
				linkedlList_dynamic.push( i );
				array_dynamic[ i - 1 ] = i;

				if ( i < fixedSize ) {
					linkedList_fixed.push( i );
					array_fixed[ i - 1 ] = i;
				}
			}
		}
	}
}
