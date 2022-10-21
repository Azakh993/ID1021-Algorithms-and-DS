package se.kth.id1021.heaps.main;

import se.kth.id1021.heaps.array.Benchmark_A;
import se.kth.id1021.heaps.array.Heap_A;
import se.kth.id1021.heaps.binarytree.Heap_T;
import se.kth.id1021.heaps.list.Benchmark_L;
import se.kth.id1021.heaps.list.Heap_L_FA;
import se.kth.id1021.heaps.list.Heap_L_FR;

import java.util.Random;

public class Main {
	public static void main( String[] args ) {
		benchA();
	}

	private static void benchA() {
		System.out.printf( "\n%8s%10s%10s%10s\n", "n", "tree", "array", "prio" );

		int passes = 1000;
		int listSize = 50;

		for ( int i = 0; i < 100; i++ ) {
			Benchmark_A.Benchmarks( listSize, passes );
			listSize *= 2;
		}
	}

	private void benchL() {
		System.out.printf( "\n%8s%10s%10s\n", "n", "lfa", "lfr" );

		int passes = 1000;
		int listSize = 50;

		for ( int i = 0; i < 100; i++ ) {
			Benchmark_L.Benchmarks( listSize, passes );
			listSize *= 2;
		}
	}

	private void testHA() {
		Heap_A heapA = new Heap_A( 10 );

		heapA.add( 1 );
		heapA.add( 4 );
		heapA.add( 3 );
		heapA.add( 6 );
		heapA.add( 7 );
		heapA.add( 2 );

		System.out.println( heapA );

		heapA.remove();
		System.out.println( heapA );
	}

	private void testHLFR() {
		Random rnd = new Random();
		Heap_L_FR heapLFr = new Heap_L_FR();
		for ( int i = 0; i < 20; i++ ) {
			heapLFr.add( rnd.nextInt( 20 ) );
		}

		Heap_L_FR.printList( heapLFr.head );
		heapLFr.remove();
		Heap_L_FR.printList( heapLFr.head );
	}

	private void testHLFA() {
		Random rnd = new Random();
		Heap_L_FA heapLFa = new Heap_L_FA();
		for ( int i = 0; i < 20; i++ ) {
			heapLFa.add( rnd.nextInt( 20 ) );
		}

		Heap_L_FA.printList( heapLFa.head );
		heapLFa.remove();
		Heap_L_FA.printList( heapLFa.head );
	}

	private void testHT() {
		Heap_T heapT = new Heap_T();
		heapT.add( 1 );
		heapT.add( 4 );
		heapT.add( 3 );
		heapT.add( 6 );
		heapT.add( 7 );


		for ( Integer i : heapT ) {
			System.out.println( "Next val: " + i );
		}

		/*
		System.out.println(heapT.root.priority);
		System.out.println(heapT.root.left.priority);
		System.out.println(heapT.root.right.priority);
		System.out.println(heapT.root.left.left.priority);

		 */
		System.out.println();
		heapT.push( 10 );

		for ( Integer i : heapT ) {
			System.out.println( "Next val: " + i );
		}
	}
}