public class MinPQ <Key extends Comparable<Key>>{
    private Key[] pq;
    private int N = 0;

    public MinPQ(int maxN){
        pq = (Key[]) new Comparable[maxN + 1];
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public int size(){
        return N;
    }

    public void insert(Key v){
        pq[++N] = v;
        swim(N);
    }

    public Key delMin(){
        Key min = pq[1];        //retrieve min key from bottom
        exch(1, N--);           //exchange with last item
        sink(1);            //restore heap
        pq[N + 1] = null;       //avoid loitering
        return min;
    }

    private boolean greater(int i, int j){
        return pq[i].compareTo(pq[j]) > 0;
    }

    private void exch(int i, int j){
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    private void swim(int k){
        while (k > 1 && greater(k/2, k)){
            exch(k/2, k);
            k = k/2;
        }
    }

    private void sink(int k){
        while (2 * k <= N){
            int j = 2 * k;
            if(j < N && greater(j, j+1)){
                j++;
            }
            if(!greater(k, j)){
                break;
            }
            exch(k, j);
            k = j;
        }
    }
}
