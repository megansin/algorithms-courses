public class Term implements Comparable<Term>{

    private String word, document;
    private int frequency = 0;
    private double tfIdfScore;

    //the word, the document it came from, the word’s
    //frequency in the document, and (eventually) it’s tf-idf score.
    public Term(String word, String document){
        this.word = word;
        this.document = document;
    }

    public String getWord(){
        return word;
    }

    public String getDocument(){
        return document;
    }

    public int getFrequency(){
        return frequency;
    }

    public void updateFrequency(){
        frequency++;
    }

    public void calcTfIdScore(int docfreq){
        //TF * IDF where
        //TF = log ( 1 + frequency-of-term-in-specific-doc)
        //IDF = log ( total-count-of-docs / count-of-term-in-all-docs)
        double tf = Math.log10(1+this.frequency);
        //14 total documents
        double idf = Math.log10(14/ (double) docfreq);
        this.tfIdfScore = tf*idf;
    }

    public double getTfIdfScore(){
        return tfIdfScore;
    }

    @Override
    public int compareTo(Term o) {
        if (tfIdfScore < o.tfIdfScore)
            return -1;
        else if (tfIdfScore > o.tfIdfScore)
            return +1;
        return 0;
    }
}
