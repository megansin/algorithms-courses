import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        // big list for comparison
        int[] allowlist = IntStream.generate(() ->
                new Random().nextInt(100000)).limit(250000).toArray();

		// KEY: convert int[] to Integer[]
        Integer[] allowlistInteger = Arrays.stream( allowlist ).boxed().toArray( Integer[]::new );
        Integer[] allowlistIntegerIS = allowlistInteger.clone();
        Integer[] allowlistIntegerQS = allowlistInteger.clone();


        // IMPORTANT, add 0 to beginning for heapsorted array
        allowlistInteger = add2BeginningOfArray(allowlistInteger, 0);

		// HS time
        Stopwatch timer1 = new Stopwatch();
        HeapSort.sort(allowlistInteger);
        double time1 = timer1.elapsedTime();
        System.out.println("HeapSort 250k time: " + time1);

        // IS time
        Stopwatch timer2 = new Stopwatch();
        InsertionSort.sort(allowlistIntegerIS);
        double time2 = timer2.elapsedTime();
        System.out.println("InsertionSort 250k time: " + time2);

		// QS time
        Stopwatch timer3 = new Stopwatch();
        QuickSort.sort(allowlistIntegerQS);
        double time3 = timer3.elapsedTime();
        System.out.println("QuickSort 250k time: " + time3);

    }

    // https://stackoverflow.com/a/52437408
    public static <T> T[] add2BeginningOfArray(T[] elements, T element) {
        T[] newArray = Arrays.copyOf(elements, elements.length + 1);
        newArray[0] = element;
        System.arraycopy(elements, 0, newArray, 1, elements.length);

        return newArray;
    }

}
