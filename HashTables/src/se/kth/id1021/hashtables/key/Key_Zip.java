package se.kth.id1021.hashtables.key;

import java.io.BufferedReader;
import java.io.FileReader;

public class Key_Zip {
	Key_Node[] data;
	int max;

	public Key_Zip( String file ) {
		data = new Key_Node[ 100_000 ];
		try ( BufferedReader reader = new BufferedReader( new FileReader( file ) ) ) {
			String line;
			int i = 0;

			while ( ( line = reader.readLine() ) != null ) {
				String[] row = line.split( "," );
				Integer code = Integer.valueOf( row[ 0 ].replaceAll( "\\s", "" ) );
				data[ code ] = new Key_Node( code, row[ 1 ], Integer.valueOf( row[ 2 ] ) );
			}
			max = i - 1;
		}
		catch ( Exception exception ) {
			System.out.println( " file " + file + " not found" );
		}
	}

	public Key_Node lookup( Integer zipCode ) {
		return data[ zipCode ];
	}
}
