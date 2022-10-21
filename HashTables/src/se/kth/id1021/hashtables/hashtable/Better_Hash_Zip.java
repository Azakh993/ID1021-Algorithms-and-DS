package se.kth.id1021.hashtables.hashtable;

import java.io.BufferedReader;
import java.io.FileReader;

public class Better_Hash_Zip {
	Hash_Node[] data;
	int buckets = 10000;
	int depth = 0;

	public Better_Hash_Zip( String file, int arraySize ) {
		buckets = arraySize;
		data = new Hash_Node[ buckets ];
		try ( BufferedReader reader = new BufferedReader( new FileReader( file ) ) ) {
			String line;
			while ( ( line = reader.readLine() ) != null ) {
				String[] row = line.split( "," );
				hash( row );
			}
		}
		catch ( Exception exception ) {
			System.out.println( " file " + file + " not found" );
		}
	}

	private void hash( String[] row ) {
		int code = Integer.parseInt( row[ 0 ].replaceAll( "\\s", "" ) );
		int hashIndex = code % buckets;
		Hash_Node nodeToAdd = new Hash_Node( code, row[ 1 ], Integer.valueOf( row[ 2 ] ) );

		if ( data[ hashIndex ] == null ) {
			data[ hashIndex ] = nodeToAdd;
		} else {
			while ( data[ hashIndex ] != null ) {
				hashIndex++;
				if ( hashIndex == data.length ) {
					hashIndex = 0;
				}
			}
		}
		data[ hashIndex ] = nodeToAdd;
	}

	public Better_Hash_Zip( String file ) {
		data = new Hash_Node[ buckets ];
		try ( BufferedReader reader = new BufferedReader( new FileReader( file ) ) ) {
			String line;
			while ( ( line = reader.readLine() ) != null ) {
				String[] row = line.split( "," );
				hash( row );
			}
		}
		catch ( Exception exception ) {
			System.out.println( " file " + file + " not found" );
		}
	}

	public Integer lookup( Integer zipCode ) {
		depth = 0;
		int hashIndex = zipCode % buckets;
		if ( data[ hashIndex ].getZipCode().equals( zipCode ) ) {
			return depth;
		} else {
			while ( !data[ hashIndex ].getZipCode().equals( zipCode ) ) {
				hashIndex++;
				depth++;
				if ( hashIndex == data.length ) {
					hashIndex = 0;
				}
			}
		}
		return depth;
	}

	public void setBuckets( int buckets ) {
		this.buckets = buckets;
	}
}
