package se.kth.id1021.hashtables.hashtable;

import java.io.BufferedReader;
import java.io.FileReader;

public class Hash_Zip {
	Hash_Node[] data;
	int buckets = 10000;
	int depth;

	public Hash_Zip( String file, int arraySize ) {
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
			nodeToAdd.setNext( data[ hashIndex ].getNext() );
			data[ hashIndex ].setNext( nodeToAdd );
		}
	}

	public Hash_Zip( String file ) {
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

	public void setBuckets( int buckets ) {
		this.buckets = buckets;
	}

	public Integer lookup( Integer zipCode ) {
		depth = 0;
		int hashIndex = zipCode % buckets;
		Hash_Node current = data[ hashIndex ];
		if ( data[ hashIndex ].getZipCode().equals( zipCode ) ) {
			return depth;
		} else {
			while ( !current.getZipCode().equals( zipCode ) ) {
				current = current.getNext();
				depth++;
			}
		}
		return depth;
	}
}
