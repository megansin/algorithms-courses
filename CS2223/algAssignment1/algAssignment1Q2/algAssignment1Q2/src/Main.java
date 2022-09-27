import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        //three trials of linear, binary, and recursive binary searches
        //number of steps for each type of search are printed at end
        for (int i = 0; i < 3; i++) {

            LinearSearch.steps = 0;
            BinarySearch.steps = 0;
            RecursiveBinarySearch.steps = 0;

            //change array size - 100, 1000, 10000, 100000, 250000
            int[] allowList = IntStream.generate(() ->
                    new Random().nextInt(1000)).limit(250000).toArray();

            int key = new Random().nextInt(1000);

            Arrays.sort(allowList);

            LinearSearch.rank(key, allowList);
            BinarySearch.rank(key, allowList);
            RecursiveBinarySearch.rankrecursive(key, allowList);

            //print number of steps in linear search
            System.out.format("Linear Search Steps: %d\n", LinearSearch.steps);
            System.out.format("Binary Search Steps: %d\n", BinarySearch.steps);
            System.out.format("Recursive Binary Search Steps: %d\n", RecursiveBinarySearch.steps);

        }


    }



}
