package se.kth.id1021.quicksort;

import java.util.Arrays;

public class Main {
	public static void main( String[] args ) {
		/*
		System.out.printf( "\n%8s%10s%10s\n", "n", "sll", "dll" );

		int passes = 1000;
		int[] sizes = new int[10];
		sizes[0] = 50;
		for ( int i = 1; i < 10; i++ ) {
			sizes[i] = 2 * sizes[i - 1];
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


		*/


		SLL sll = new SLL();
		sll.push(new SLL.Node(26));
		sll.push(new SLL.Node(25));
        sll.push( new SLL.Node(30) );
		sll.push(new SLL.Node(15));
		sll.push(new SLL.Node(45));
		sll.push(new SLL.Node(55));
		sll.push(new SLL.Node(10));
		sll.push(new SLL.Node(60));
		sll.push(new SLL.Node(0));
		sll.push(new SLL.Node(5));
		sll.push(new SLL.Node(25));
		sll.push(new SLL.Node(70));
		sll.push(new SLL.Node(23));
		sll.push(new SLL.Node(40));
		sll.push(new SLL.Node(34));
		sll.push(new SLL.Node(25));

        System.out.print("Before sorting: ");
        sll.printList(sll.head);
		SLL_QS.sort(sll.head, sll.tail);
        System.out.print("\nAfter sorting: ");
        sll.printList(sll.head);

	}
}