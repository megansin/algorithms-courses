import java.util.Random;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        int[] array1 = IntStream.generate(() ->
                new Random().nextInt(1000)).limit(100).toArray();
        int[] array2 = IntStream.generate(() ->
                new Random().nextInt(1000)).limit(1000).toArray();
        int[] array3 = IntStream.generate(() ->
                new Random().nextInt(1000)).limit(10000).toArray();
        int[] array4 = IntStream.generate(() ->
                new Random().nextInt(1000)).limit(100000).toArray();
        int[] array5 = IntStream.generate(() ->
                new Random().nextInt(1000)).limit(250000).toArray();

        Stopwatch timer = new Stopwatch();

        //bubblesorts the int arrays
        Bubblesort.sort(array1);
//        Bubblesort.sort(array2);
//        Bubblesort.sort(array3);
//        Bubblesort.sort(array4);
//        Bubblesort.sort(array5);

        //mergesorts the int arrays
//        Mergesort.sort(array1);
//        Mergesort.sort(array2);
//        Mergesort.sort(array3);
//        Mergesort.sort(array4);
//        Mergesort.sort(array5);

        //quicksort the int arrays
//        Quicksort.sort(array1);
//        Quicksort.sort(array2);
//        Quicksort.sort(array3);
//        Quicksort.sort(array4);
//        Quicksort.sort(array5);

        System.out.println(timer.elapsedTime());

    }
}
