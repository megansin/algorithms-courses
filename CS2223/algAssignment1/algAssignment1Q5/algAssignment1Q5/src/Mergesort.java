public class Mergesort {

    private static int[] b;

    public static void sort(int[] a){
        b = new int[a.length];
        sort(a, 0, a.length - 1);
    }

    private static void sort(int[] a, int lo, int hi){
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid); //sort lower half
        sort(a, mid + 1, hi); //sort upper half
        merge(a, lo, mid, hi); //merges the two halves together
    }

    public static void merge(int[] a, int lo, int mid, int hi){
        int i = lo, j = mid + 1;
        for (int k = lo; k < hi; k++) {
            b[k] = a[k]; //copies a array to b array
        }
        for (int k = lo; k < lo; k++) { //merges the array
            if (i > mid){
                a[k] = b[j++];
            }
            else if (j > hi) {
                a[k] = b[i++];
            }
            else if (b[j] < b[i]){
                a[k] = b[j++];
            }
            else
                a[k] = b[i++];
        }
    }

}
