package se.kth.id1021.arraysearching;

public class SearchingAlgorithms {

    static boolean search_unsorted(int[] array, int key) {
        for (int i : array) {
            if (i == key) {
                return true;
            }
        }
        return false;
    }
    static boolean binary_search( int[] array, int key ) { // O(log n)
        int first = 0;
        int last = array.length - 1;
        while ( first <= last ) {
            int middleIndex = ( last + first ) / 2;
            if ( array[ middleIndex ] == key ) {
                return true;
            }

            if ( array[ middleIndex ] < key && middleIndex < last ) {
                first = middleIndex + 1;
                continue;
            }

            if ( array[ middleIndex ] > key && middleIndex > first ) {
                last = middleIndex - 1;
            }
        }
        return false;
    }

    static boolean[] array_binary_search( int[] array, int[] keyArray ) { // O(n log n)
        boolean[] searchResults = new boolean[ keyArray.length ];
        int first = 0;
        int last = array.length - 1;
        for ( int i = 0; i < keyArray.length; i++ ) {
            while ( first <= last ) {
                int middleIndex = ( last + first ) / 2;
                if ( array[ middleIndex ] == keyArray[ i ] ) {
                    searchResults[ i ] = true;
                    break;
                }

                if ( array[ middleIndex ] < keyArray[ i ] && middleIndex < last ) {
                    first = middleIndex + 1;
                    continue;
                }
                if ( array[ middleIndex ] > keyArray[ i ] && middleIndex > first ) {
                    last = middleIndex - 1;
                }
            }
            if ( !searchResults[ i ] ) {
                searchResults[ i ] = false;
            }
        }
        return searchResults;
    }

    static boolean[] improved_array_search( int[] array, int[] keyArray ) { // O(n)
        boolean[] searchResults = new boolean[ keyArray.length ];
        int i = 0, j = 0;
        while ( j < keyArray.length && i < array.length ) {
            if ( array[ i ] == keyArray[ j ] ) {
                searchResults[ j++ ] = true;
                i++;
            } else if ( array[ i ] < keyArray[ j ] ) {
                i++;
            } else {
                searchResults[ j ] = false;
                j++;
            }
        }
        return searchResults;
    }
}
