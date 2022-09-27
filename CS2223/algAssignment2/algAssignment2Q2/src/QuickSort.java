import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class QuickSort {
    private static Integer[] aux; // auxiliary array for merges

    public static void sort(Integer[] a) {
//		StdRandom.shuffle(a); // Eliminate dependence on input.
//		Collections.shuffle(Arrays.asList(a));
        shuffleArray(a);
        sort(a, 0, a.length - 1);
    }

    private static void sort(Integer[] a, int lo, int hi) {
        if (hi <= lo)
            return;
        int j = partition(a, lo, hi); // Partition (see page 291).
        sort(a, lo, j-1); // Sort left part a[lo .. j-1].
        sort(a, j+1, hi); // Sort right part a[j+1 .. hi].
    }

    private static int partition(Integer[] a, int lo, int hi) {
        // Partition into a[lo..i-1], a[i], a[i+1..hi].
        int i = lo, j = hi + 1; // left and right scan indices
        Integer v = a[lo]; // partitioning item

        while (true) { // Scan right, scan left, check for scan complete, and exchange.
            while (less(a[++i], v))
                if (i == hi)
                    break;
            while (less(v, a[--j]))
                if (j == lo)
                    break;
            if (i >= j)
                break;
            exch(a, i, j);
        }

        exch(a, lo, j); // Put v = a[j] into position

        return j; // with a[lo..j-1] <= a[j] <= a[j+1..hi].

    }

    private static void exch(Integer[] a, int i, int j) {
        Integer t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static boolean less(Integer v, Integer w) {
        return v.compareTo(w) < 0;
    }

    public static void show(Integer[] a) { // Print the array, on a single line.
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    public static boolean isSorted(Integer[] a) { // Test whether the array entries are in order.
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i - 1]))
                return false;
        return true;
    }

    // Implementing Fisher–Yates shuffle
    // https://stackoverflow.com/a/1520212
    static void shuffleArray(Integer[] ar) {
        // If running on Java 6 or older, use `new Random()` on RHS here
        Random rnd = ThreadLocalRandom.current();
        for (int i = ar.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            Integer a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }
}