package se.kth.id1021.graphs;

public class Naive {
	private static int max;
	public static void main(String[] args) {
		Map map = new Map("trains.csv");
		String from = args[0];
		String to = args[1];
		max = Integer.parseInt( args[2] );
		long  t0 = System.nanoTime();
		Integer dist = shortest(map.lookup(from), map.lookup(to), max);
		long time = (System.nanoTime() - t0)/1_000_000;
		System.out.println("shortest: " + dist + " min (" + time + " ms)");
	}

	private static Integer shortest(City start, City destination, Integer max) {
		if (max < 0)
			return null;
		if (start == destination)
			return 0;
		Integer shortest = null;

		for (int i = 0; i < start.getNeighbours().length; i++) {
			if (start.getNeighbours()[i] != null) {
				Connection connection = start.getNeighbours()[i];
				shortest = shortest( connection.getCity(), destination, max - connection.getDistance() );
			}
		}
		return shortest;
	}

	}
