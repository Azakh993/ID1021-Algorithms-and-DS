package se.kth.id1021.hashtables.integer;

import java.io.BufferedReader;
import java.io.FileReader;

public class Integer_Zip {
	public Integer_Node[] data;
	public int max;

	public Integer_Zip( String file ) {
		data = new Integer_Node[ 10_000 ];

		try ( BufferedReader reader = new BufferedReader( new FileReader( file ) ) ) {
			String line;
			int i = 0;

			while ( ( line = reader.readLine() ) != null ) {
				String[] row = line.split( "," );
				Integer code = Integer.valueOf( row[ 0 ].replaceAll( "\\s", "" ) );
				data[ i++ ] = new Integer_Node( code, row[ 1 ], Integer.valueOf( row[ 2 ] ) );
			}
			max = i - 1;
		}
		catch ( Exception exception ) {
			System.out.println( " file " + file + " not found" );
		}
	}

	public Integer_Node linear_lookup( Integer zipCode ) {
		int i = 0;
		while ( !data[ i ].getZipCode().equals( zipCode ) && i <= max ) {
			i++;
		}
		return data[ i ].getZipCode().equals( zipCode ) ? data[ i ] : null;
	}

	public Integer_Node binary_lookup( Integer zipCode ) {
		return binarySearch( data, zipCode, 0, max );
	}

	private Integer_Node binarySearch( Integer_Node[] data, Integer zipCode, int left, int right ) {
		if ( right >= left ) {
			int middle = left + ( right - left ) / 2;
			if ( data[ middle ].getZipCode().intValue() == zipCode.intValue() ) {
				return data[ middle ];
			}
			if ( data[ middle ].getZipCode() > zipCode ) {
				return binarySearch( data, zipCode, left, middle - 1 );
			}

			return binarySearch( data, zipCode, middle + 1, right );
		}
		return null;
	}
}
