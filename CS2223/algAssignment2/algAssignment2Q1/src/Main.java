import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

//        //max pq
//        int[] one = IntStream.generate(() -> new Random().nextInt(1000)).limit(20).toArray();
//        Integer[] oneI = Arrays.stream(one).boxed().toArray(Integer[]::new);
//        MaxPQ<Integer> maxPQ = new MaxPQ<>(oneI.length + 1);
//
//        //insert random integers into the max priority queue
//        for (Integer num : oneI) {
//            maxPQ.insert(num);
//        }
//
//        //create new stack
//        Stack<Integer> stack = new Stack<>();
//
//        //push max from priority queue into stack
//        while (!maxPQ.isEmpty()){
//            stack.push(maxPQ.delMax());
//        }
//
//        //print out sorted stack
//        for (Integer i : stack){
//            System.out.println(i);
//        }
//
        //min pq for 4a

        //generate random integers
        int[] two = IntStream.generate(() -> new Random().nextInt(1000)).limit(20).toArray();
        Integer[] twoI = Arrays.stream(two).boxed().toArray(Integer[]::new);
        MinPQ<Integer> minPQ = new MinPQ<>(twoI.length + 1);

        //put random integers into priority queue
        for (Integer num : twoI){
            minPQ.insert(num);
        }

        //create new stack
        Stack<Integer> stack2 = new Stack<>();

        //pushes min from priority queue into stack
        while (!minPQ.isEmpty()){
            stack2.push(minPQ.delMin());
        }

        //print out sorted stack
        for (Integer i : stack2){
            System.out.println(i);
        }

        //4b
        //creates eggs
        Egg barry = new Egg("Blue Jay", 2, 6);
        Egg bob = new Egg("Blue Jay", 2, 6);
        Egg perry = new Egg("Platypus", 0.4, 1);
        Egg patty = new Egg("Platypus", 0.48, 0.89);
        Egg ozzy = new Egg("Ostrich", 6, 10);
        Egg oli = new Egg("Ostrich", 5.6, 9.7);
        Egg chuck = new Egg("Chicken", 1, 3);
        Egg carl = new Egg("Chicken", 1.4, 2.7);
        Egg tuck = new Egg("Turtle", 0.75,4);
        Egg tim = new Egg("Turtle", 0.8,4.3);
        Egg sid = new Egg("Snake", 2.5, 3.1);
        Egg sam = new Egg("Snake", 2.8, 3.1);

        //put eggs into array
        Egg[] eggs = {barry, bob, perry, patty, ozzy, oli, chuck, carl, tuck, tim, sid, sam};

        //create new priority queue
        MinPQ<Egg> eggMinPQ = new MinPQ<>(eggs.length + 1);

        //put eggs into priority queue
        for (Egg e : eggs){
            eggMinPQ.insert(e);
        }

        //create new stack
        Stack<Egg> stack3 = new Stack<>();

        //push mins from priority queue into stack
        while (!eggMinPQ.isEmpty()){
            stack3.push(eggMinPQ.delMin());
        }

        //print out the weights in stack
        System.out.println("Sorted egg weights:");
        for (Egg egg : stack3){
            System.out.println(egg.getWeight());
        }

    }
}
