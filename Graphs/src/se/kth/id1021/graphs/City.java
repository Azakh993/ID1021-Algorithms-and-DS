package se.kth.id1021.graphs;

class City {
	private String name;
	private Connection[] neighbours;
	private int number_of_connections;
	private City next_in_bucket;

	City( String name ) {
		this.name = name;
		this.number_of_connections = 0;
		this.neighbours = new Connection[ 10 ];
	}

	void addConnection( City destination, Integer distance ) {
		if ( isFull() ) {
			expandArray();
		}
		neighbours[ number_of_connections ] = new Connection( destination, distance );
		number_of_connections++;
	}

	private boolean isFull() {
		return neighbours.length == number_of_connections;
	}

	private void expandArray() {
		int new_size = neighbours.length * 2;
		Connection[] largerArray = new Connection[ new_size ];
		for ( int i = 0; i < neighbours.length; i++ ) {
			largerArray[ i ] = neighbours[ i ];
		}
		neighbours = largerArray;
	}

	public void setNext_in_bucket( City next_in_bucket ) {
		this.next_in_bucket = next_in_bucket;
	}

	public City next_in_bucket() {
		return next_in_bucket;
	}

	String getName() {
		return name;
	}

	void setName( String name ) {
		this.name = name;
	}

	Connection[] getNeighbours() {
		return neighbours;
	}

	void setNeighbours( Connection[] neighbours ) {
		this.neighbours = neighbours;
	}
}
