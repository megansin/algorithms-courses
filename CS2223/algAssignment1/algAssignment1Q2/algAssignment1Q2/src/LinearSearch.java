public class LinearSearch {
    public static int steps = 0;

    public static int rank (int key,int[] a){

        for (int i = 0; i < a.length; i++) {
            steps++;
            if (a[i] == key) {
                return i;
            }
        }

        return -1;

    }

}
