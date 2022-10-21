package se.kth.id1021.graphs;

import java.io.BufferedReader;
import java.io.FileReader;

class Map {
	private final int BUCKETS = 541;
	private City[] cities;

	Map( String file ) {
		cities = new City[ BUCKETS ];
		try ( BufferedReader br = new BufferedReader( new FileReader( file ) ) ) {
			String line;
			while ( ( line = br.readLine() ) != null ) {
				String[] row = line.split( "," );

				String first_city_name = row[ 0 ];
				String second_city_name = row[ 1 ];
				Integer distance = Integer.valueOf( row[ 2 ] );

				City first_city = lookup( first_city_name );
				City second_city = lookup( second_city_name );

				first_city.addConnection( second_city, distance );
				second_city.addConnection( first_city, distance );
			}
		}
		catch ( Exception exception ) {
			System.out.println( " file " + file + " not found or corrupt" );
		}
	}

	City lookup( String city_name ) {
		Integer hashed_index = hash( city_name );
		City current = cities[ hashed_index ];
		if ( current == null ) {
			current = new City( city_name );
		} else {
			while ( current != null && !current.getName().equals( city_name ) )
				current = current.next_in_bucket();
			if ( current == null )
				current = new City( city_name );
			else
				return current;
		}
		return current;
	}

	private Integer hash( String city_name ) {
		int hash = 7;
		for ( int i = 0; i < city_name.length(); i++ ) {
			hash = ( hash * 31 % BUCKETS ) + city_name.charAt( i );
		}
		return hash % BUCKETS;
	}
}
