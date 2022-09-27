import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Quicksort {

    public static void sort(int[] a){
        shuffleArray(a);
        sort(a, 0, a.length - 1);
    }

    private static void sort(int[] a, int lo, int hi){
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j-1); //sort left part
        sort(a, j+1, hi); //sort right part
    }

    private static int partition(int[] a, int lo, int hi) {
        // Partition into a[lo..i-1], a[i], a[i+1..hi].
        int i = lo, j = hi + 1; // left and right scan indices
        int v = a[lo]; // partitioning item

        while (true) { // Scan right, scan left, check for scan complete, and exchange.
            while (a[++i] < v)
                if (i == hi)
                    break;
            while (v < a[--j])
                if (j == lo)
                    break;
            if (i >= j)
                break;
            exch(a, i, j);
        }

        exch(a, lo, j); // Put v = a[j] into position

        return j; // with a[lo..j-1] <= a[j] <= a[j+1..hi].

    }

    private static void exch(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    static void shuffleArray(int[] ar){
        Random rnd = ThreadLocalRandom.current();
        for (int i = ar.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            int a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }


}
