package se.kth.id1021.quicksort;

class Array_QS {

	public static void sort(int[] arrayToSort, int left, int right) {
		if (left < right) {
			int partitionIndex = partition(arrayToSort, left, right);
			sort(arrayToSort, left, partitionIndex -1);
			sort(arrayToSort, partitionIndex+1, right);
		}
	}

	private static int partition( int[] array, int left, int right ) {
		int pivot = array[right];
		int i = (left-1);

		for (int j = left; j < right; j++)
			if ( array[j] <= pivot)
				swap( array, ++i, j );

		swap( array, i + 1, right);
		return i+1;
	}

	private static void swap( int[] array, int i, int j) {
		int swapTemp = array[i];
		array[i] = array[j];
		array[j] = swapTemp;
	}

}
