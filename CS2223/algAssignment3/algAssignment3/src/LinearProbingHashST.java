import java.util.Iterator;

public class LinearProbingHashST<Key, Value> implements Iterable<Value>{
    private int N;
    private int M = 16;
    private Key[] keys;
    private Value[] vals; // the values
// number of key-value pairs in the table // size of linear-probing table
// the keys

    public LinearProbingHashST() {
        keys = (Key[]) new Object[M];
        vals = (Value[]) new Object[M];
    }

    public LinearProbingHashST(int cap) {
        M = cap;
        keys = (Key[]) new Object[cap];
        vals = (Value[]) new Object[cap];
    }

    // could make hash private
//	private int hash(Key key) {
    // 0x7fffffff -> https://stackoverflow.com/questions/46625819/what-does-0x7fffffff-mean-in-inttime-time1000-0-0x7fffffff
    public int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    private void resize(int cap) {
        LinearProbingHashST<Key, Value> t;
        t = new LinearProbingHashST<Key, Value>(cap);
        for (int i = 0; i < M; i++)
            if (keys[i] != null)
                t.put(keys[i], vals[i]);
        keys = t.keys;
        vals = t.vals;
        M = t.M;
    }

    public void put(Key key, Value val) {
        if (N >= M / 2)
            resize(2 * M); // double M (see text)
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % M)
            if (keys[i].equals(key)) {
                vals[i] = val;
                return;
            }
        keys[i] = key;
        vals[i] = val;
        N++;
    }

    public Value get(Key key) {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % M)
            if (keys[i].equals(key))
                return vals[i];
        return null;
    }

    public void delete(Key key)	{
        if (!contains(key)) return;
        int i = hash(key);
        while (!key.equals(keys[i]))
            i = (i + 1) % M;

        keys[i] = null;
        vals[i] = null;
        i = (i + 1) % M;
        while (keys[i] != null)
        {
            Key   keyToRedo = keys[i];
            Value valToRedo = vals[i];
            keys[i] = null;
            vals[i] = null;
            N--;
            put(keyToRedo, valToRedo);
            i = (i + 1) % M;
        }
        N--;
        if (N > 0 & N == M/8) resize(M/2);
    }

    public boolean contains(Key key) {
        if(get(key) != null)
            return true;
        else
            return false;
    }

    public int size() {
        int size = 0;
        for (Value currentTerm : this) {
            if (currentTerm != null)
                size++;
        }
        return size;
    }

    public Iterator<Value> iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<Value> {
        private int i = 0;

        public boolean hasNext() {
            return i < M;
        }

        public Value next() {
            return vals[i++];
        }

        public void remove() {
        }
    }
}