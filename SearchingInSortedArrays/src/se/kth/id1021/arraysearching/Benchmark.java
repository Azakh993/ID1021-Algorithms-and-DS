package se.kth.id1021.arraysearching;

import java.util.Random;

class Benchmark {
    static void search_unsorted_benchmark(int initialSize, int passes){
        int[] randomArray = Arrays.unsortedArray(initialSize);
        int randomKey = new Random().nextInt( initialSize * 10);

        double shortest_time = Double.POSITIVE_INFINITY;
        long startTime = 0;
        long endTime = 0;

        for ( int k = 1; k < 17; k++) {
            int arraySize = initialSize;

            for (int i = 0; i < passes; i++) {
                startTime = System.nanoTime();
                for (int j = 0; j < arraySize; j++) {
                    SearchingAlgorithms.search_unsorted(randomArray, randomKey);
                }
                endTime = System.nanoTime();

                if (endTime - startTime < shortest_time)
                    shortest_time = endTime - startTime;
            }
            arraySize *= k;
            randomArray = Arrays.unsortedArray(arraySize);
            randomKey = new Random().nextInt( arraySize * 10);
            System.out.println("Size: " + arraySize + "\tTime: " + shortest_time);
        }
    }
}
