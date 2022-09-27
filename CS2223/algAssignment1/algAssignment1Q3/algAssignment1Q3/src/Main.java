import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        int sum = 0;

        Stopwatch one = new Stopwatch();
        for (int i = 0; i < 100000; i++) {
            sum += i;
        }
        System.out.println(one.elapsedTime());

        Stopwatch two = new Stopwatch();
        for (int i = 0; i < 100000; i++) {
            for (int j = 0; j < 100000; j++) {
                sum += j;
            }
        }
        System.out.println(two.elapsedTime());

        Stopwatch three = new Stopwatch();
        for (int i = 0; i < 100000; i++) {
            for (int j = 0; j < 100000; j++) {
                for (int k = 0; k < 100000; k++) {
                    sum += k;
                }
            }
        }
        System.out.println(three.elapsedTime());
    }




}
