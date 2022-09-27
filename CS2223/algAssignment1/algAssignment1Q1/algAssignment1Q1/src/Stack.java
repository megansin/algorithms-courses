import java.util.Iterator;

public class Stack<Item> implements Iterable<Item> {
    private Item[] a = (Item[]) new Object[1];
    private int N = 0;

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(Item item) {
        if (N == a.length){
            resize(2*a.length);
        }
        a[N++] = item;
    }

    public Item pop() {
        //remove items from top of stack
        Item item = a[--N]; //decrease, then return
        a[N] = null; //avoid loitering (see text)
        if (N > 0 && N == a.length / 4){
            resize(a.length / 2);
        }

        return item;
    }

    private void resize(int max) {
        //move stack to a new array of size max
        Item[] temp = (Item[]) new Object[max];

        for (int i = 0; i < N; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> {
        private int i = N;

        public boolean hasNext() {
            return i > 0;
        }

        public Item next() {
            return a[--i];
        }

        public void remove(){}

    }

}
