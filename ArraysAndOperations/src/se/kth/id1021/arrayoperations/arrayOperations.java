package se.kth.id1021.arrayoperations;

import java.util.Random;

public class arrayOperations {
    public static void main(String[] args) {
        //access(10000);
        //System.out.printf("Time: " + access(100000) + "ns");

        search(100, 1000);
        System.out.printf("Time: " + search(100, 50000) + "ns");
        }

    private static double access(int n) {
        int k = 100_000; // number of runs
        int l = n; // array size

        Random rnd = new Random();

        int[] rndIndx = new int[l];
        for (int i = 0; i < l; i++)
            rndIndx[i] = rnd.nextInt(n); // fill the rndIndx array with random number from 0 to n (not including n)
            
        int[] mainArray = new int[n];
        for (int i = 0; i < l; i++)
            mainArray[i] = 1; // fill the array with dummy values (why not 1)

        int sum = 0;
        long t0 = System.nanoTime();
        for (int j = 0; j < k; j++)
            for (int i = 0; i < l; i++)
                sum += mainArray[rndIndx[i]]; // access the array with the index given by rndIndx[i], sum up the result

        long t_access = (System.nanoTime() - t0);

        t0 = System.nanoTime();
        for (int j = 0; j < k; j++)
            for (int i = 0; i < l; i++)
                sum++; // do the same loop iteration but only do a dummy add operation

        long t_dummy = (System.nanoTime() - t0);

        return ((double)(t_access - t_dummy))/((double)k*(double)l);
    }

    private static double search(int n, int k) {
        int m = n*2;
        int[] keys = new int[m];
        int[] array = new int[n];

        Random rnd = new Random();

        int sum = 0;
        long t_total = 0;
        for (int j = 0; j < k; j++) {
            
            for (int i = 0; i < m; i++)
                keys[i] = rnd.nextInt(10*n); // fill the keys array with random number from 0 to 10*n

            for (int i = 0; i < n; i++)
                array[i] = rnd.nextInt(10*n); // fill the array with with random number from 0 to 10*n

            long t0 = System.nanoTime();
            for (int ki = 0; ki < m; ki++) {
                int key = keys[ ki ];

                for ( int i = 0; i < n; i++ ) {
                    if ( array[ i ] == key ) {
                        sum++;
                        break;
                    }
                }
            }
            t_total += (System.nanoTime() - t0);
        }

        return ((double) t_total / ((double) k ));
    }
}
