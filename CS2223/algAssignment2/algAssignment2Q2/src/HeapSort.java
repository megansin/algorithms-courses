public class HeapSort {

    //integrate a[] into compare
    private static boolean less(Integer a[], int i, int j){
        return a[i].compareTo(a[j]) < 0;
    }

    //integrate a[] into exch
    private static void exch(Integer a[], int i, int j){
        Integer t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    //integrate a[] and N into sink
    private static void sink(Integer a[], int k, int N){
        while(2 * k <= N){
            int j = 2 * k;
            if(j < N && less(a, j, j+1)){
                j++;
            }
            if(!less(a, k, j)){
                break;
            }
            exch(a, k, j);
            k = j;
        }
    }

    //our static HEAPSORT method
    public static void sort(Integer[] a){
        int N = a.length-1;
        for(int k = N/2; k >= 1; k--){
            sink(a, k, N);
        }
        while(N > 1){
            exch(a, 1, N--);
            sink(a, 1, N);
        }
    }

    //test whether the array entries are in order
    public static boolean isSorted(Integer[] a){
        for (int i = 1; i < a.length; i++) {
            if(less(a, i, i-1)){
                return false;
            }
        }
        return true;
    }

}
