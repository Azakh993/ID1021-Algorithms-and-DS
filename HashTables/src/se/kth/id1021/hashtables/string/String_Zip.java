package se.kth.id1021.hashtables.string;

import java.io.BufferedReader;
import java.io.FileReader;

public class String_Zip {
	String_Node[] data;
	int max;

	public String_Zip( String file ) {
		data = new String_Node[ 10000 ];

		try ( BufferedReader reader = new BufferedReader( new FileReader( file ) ) ) {
			String line;
			int i = 0;

			while ( ( line = reader.readLine() ) != null ) {
				String[] row = line.split( "," );
				data[ i++ ] = new String_Node( row[ 0 ], row[ 1 ], Integer.valueOf( row[ 2 ] ) );
			}
			max = i - 1;
		}
		catch ( Exception exception ) {
			System.out.println( " file " + file + " not found" );
		}
	}

	public String_Node linear_lookup( String zipCode ) {
		int i = 0;
		while ( !data[ i ].getZipCode().equals( zipCode ) && i <= max ) {
			i++;
		}
		return data[ i ].getZipCode().equals( zipCode ) ? data[ i ] : null;
	}

	public String_Node binary_lookup( String zipCode ) {
		return binarySearch( data, zipCode, 0, max );
	}

	private String_Node binarySearch( String_Node[] data, String zipCode, int left, int right ) {
		if ( right >= left ) {
			int middle = left + ( right - left ) / 2;
			if ( data[ middle ].getZipCode().equals( zipCode ) ) {
				return data[ middle ];
			}
			if ( data[ middle ].getZipCode().compareTo( zipCode ) > 0 ) {
				return binarySearch( data, zipCode, left, middle - 1 );
			}

			return binarySearch( data, zipCode, middle + 1, right );
		}
		return null;
	}
}
