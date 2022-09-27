public class RecursiveBinarySearch {

    public static int steps;

    public static int rankrecursive(int key, int[]a){
        return rankrecursive(key, a, 0, a.length-1);
    }

    public static int rankrecursive(int key, int[]a, int lo, int hi){
        steps++;
        if (lo > hi){
            return -1;
        }
        int mid = lo + (hi-lo) / 2;
        if (key < a[mid]){
            return rankrecursive(key, a, lo, mid-1);
        }
        else if (key > a[mid]){
            return rankrecursive(key, a, mid+1, hi);
        }

        else {
            return mid;
        }
    }

}
