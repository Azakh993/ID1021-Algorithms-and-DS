package se.kth.id1021.doublylinkedlists;

public class Main {
	public static void main( String[] args ) {

		System.out.printf( "\n%8s%10s%10s\n", "n", "sll", "dll" );

		int passes = 5000;
		int listSize = 5;
		int operations = 1000;

		for ( int i = 0; i < 100; i++ ) {
			Benchmark.Benchmarks( listSize, operations, passes );
			listSize *= 2;
		}

		/*

		SLL sll = new SLL();
		DLL dll = new DLL();

		SLL.Node first_node_sll = new SLL.Node( 0 );
		DLL.Node first_node_dll = new DLL.Node( 0 );

		SLL.Node second_node_sll = new SLL.Node( 1 );
		DLL.Node second_node_dll = new DLL.Node( 1 );

		SLL.Node third_node_sll = new SLL.Node( 2 );
		DLL.Node third_node_dll = new DLL.Node( 2 );

		sll.push( first_node_sll );
		sll.push( second_node_sll );
		sll.push( third_node_sll );

		dll.push( first_node_dll );
		dll.push( second_node_dll );
		dll.push( third_node_dll );

		sll.display();
		dll.display();

		sll.remove( third_node_sll );
		sll.display();

		dll.remove( third_node_dll );
		dll.display();

		sll.remove( first_node_sll );
		sll.display();

		dll.remove( first_node_dll );
		dll.display();

		sll.remove( second_node_sll );
		sll.display();

		dll.remove( second_node_dll );
		dll.display();

		sll.push( first_node_sll );
		sll.push( second_node_sll );
		sll.push( third_node_sll );

		dll.push( first_node_dll );
		dll.push( second_node_dll );
		dll.push( third_node_dll );

		sll.display();
		dll.display();

		 */
	}
}


