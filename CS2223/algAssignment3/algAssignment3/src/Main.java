import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner; // Import the Scanner class to read text files

public class Main {

    public static void main(String[] args) {

        //combined hashtable for all documents
        LinearProbingHashST<String, Term> DocFreq = new LinearProbingHashST<String, Term>();

        //read all documents in 'data' folder
        try {
            File folder = new File("src/data/");

            for (File file : folder.listFiles()) {

                Scanner myReader = new Scanner(file);

                while (myReader.hasNextLine()) {
                    String[] data = myReader.nextLine().replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
                    for (String s : data) {

                        if(DocFreq.contains(s)){
                            DocFreq.get(s).updateFrequency();
                        }
                        else{
                            Term term = new Term(s, "all");
                            term.updateFrequency();
                            DocFreq.put(s, term);
                        }

                    }

                }
                myReader.close();
            }

        }

        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        //hashtable for each document
        LinearProbingHashST<String, Term> bustopher = new LinearProbingHashST<String, Term>();
        Stopwatch one = new Stopwatch();
        docMap("bustopher-jones-the-cat-about-town.txt", bustopher);
        updateTfId(bustopher, DocFreq);
        System.out.println("Construction of bustopher: " + one.elapsedTime() + "s");

        LinearProbingHashST<String, Term> growltigers = new LinearProbingHashST<String, Term>();
        Stopwatch two = new Stopwatch();
        docMap("growltigers-last-stand.txt", growltigers);
        updateTfId(growltigers, DocFreq);
        System.out.println("Construction of growltigers: " + two.elapsedTime() + "s");

        LinearProbingHashST<String, Term> gus = new LinearProbingHashST<String, Term>();
        Stopwatch three = new Stopwatch();
        docMap("gus-the-theater-cat.txt", gus);
        updateTfId(gus, DocFreq);
        System.out.println("Construction of gus: " + three.elapsedTime() + "s");

        LinearProbingHashST<String, Term> macavity = new LinearProbingHashST<String, Term>();
        Stopwatch four = new Stopwatch();
        docMap("macavity-the-mystery-cat.txt", macavity);
        updateTfId(macavity, DocFreq);
        System.out.println("Construction of macavity: " + four.elapsedTime() + "s");

        LinearProbingHashST<String, Term> mr = new LinearProbingHashST<String, Term>();
        Stopwatch five = new Stopwatch();
        docMap("mr-mistoffelees.txt", mr);
        updateTfId(mr, DocFreq);
        System.out.println("Construction of mr mistoffelees: " + five.elapsedTime() + "s");

        LinearProbingHashST<String, Term> mungojerrie = new LinearProbingHashST<String, Term>();
        Stopwatch six = new Stopwatch();
        docMap("mungojerrie-and-rumpelteazer.txt", mungojerrie);
        updateTfId(mungojerrie, DocFreq);
        System.out.println("Construction of mungojerrie: " + six.elapsedTime() + "s");

        LinearProbingHashST<String, Term> awefull = new LinearProbingHashST<String, Term>();
        Stopwatch seven = new Stopwatch();
        docMap("of-the-awefull-battle-of-the-pekes-and-the-pollicles.txt", awefull);
        updateTfId(awefull, DocFreq);
        System.out.println("Construction of awefull: " + seven.elapsedTime() + "s");

        LinearProbingHashST<String, Term> old = new LinearProbingHashST<String, Term>();
        Stopwatch eight = new Stopwatch();
        docMap("old-deuteronomy.txt", old);
        updateTfId(old, DocFreq);
        System.out.println("Construction of old deuteronomy: " + eight.elapsedTime() + "s");

        LinearProbingHashST<String, Term> skimble = new LinearProbingHashST<String, Term>();
        Stopwatch nine = new Stopwatch();
        docMap("skimbleshanks-the-railway-cat.txt", skimble);
        updateTfId(skimble, DocFreq);
        System.out.println("Construction of skimble: " + nine.elapsedTime() + "s");

        LinearProbingHashST<String, Term> ad = new LinearProbingHashST<String, Term>();
        Stopwatch ten = new Stopwatch();
        docMap("the-ad-dressing-of-cats.txt", ad);
        updateTfId(ad, DocFreq);
        System.out.println("Construction of ad: " + ten.elapsedTime() + "s");

        LinearProbingHashST<String, Term> naming = new LinearProbingHashST<String, Term>();
        Stopwatch eleven = new Stopwatch();
        docMap("the-naming-of-cats.txt", naming);
        updateTfId(naming, DocFreq);
        System.out.println("Construction of naming: " + eleven.elapsedTime() + "s");

        LinearProbingHashST<String, Term> oldGrumbie = new LinearProbingHashST<String, Term>();
        Stopwatch twelve = new Stopwatch();
        docMap("the-old-gumbie-cat.txt", oldGrumbie);
        updateTfId(oldGrumbie, DocFreq);
        System.out.println("Construction of oldGrumbie: " + twelve.elapsedTime() + "s");

        LinearProbingHashST<String, Term> rum = new LinearProbingHashST<String, Term>();
        Stopwatch thirteen = new Stopwatch();
        docMap("the-rum-tum-tugger.txt", rum);
        updateTfId(rum, DocFreq);
        System.out.println("Construction of rum: " + thirteen.elapsedTime() + "s");

        LinearProbingHashST<String, Term> song = new LinearProbingHashST<String, Term>();
        Stopwatch fourteen = new Stopwatch();
        docMap("the-song-of-the-jellicles.txt", song);
        updateTfId(song, DocFreq);
        System.out.println("Construction of song: " + fourteen.elapsedTime() + "s");
        System.out.println();

        LinkedList<LinearProbingHashST<String, Term>> hashList = new LinkedList<LinearProbingHashST<String, Term>>();
        hashList.add(bustopher);
        hashList.add(growltigers);
        hashList.add(gus);
        hashList.add(macavity);
        hashList.add(mr);
        hashList.add(mungojerrie);
        hashList.add(awefull);
        hashList.add(old);
        hashList.add(skimble);
        hashList.add(ad);
        hashList.add(naming);
        hashList.add(oldGrumbie);
        hashList.add(rum);
        hashList.add(song);

        //search(Key)
        //"the" is in ever document
        search("the", hashList);
        //"bustopher" is only in one document
        search("bustopher", hashList);
        //"apple" is in no document
        search("apple", hashList);

        LinearProbingHashST<String, LinearProbingHashST<String, Term>> documents = new LinearProbingHashST<String, LinearProbingHashST<String, Term>>();
        documents.put("bustopher-jones-the-cat-about-town.txt", bustopher);
        documents.put("growltigers-last-stand.txt", growltigers);
        documents.put("gus-the-theater-cat.txt", gus);
        documents.put("macavity-the-mystery-cat.txt", macavity);
        documents.put("mr-mistoffelees.txt", mr);
        documents.put("mungojerrie-and-rumpelteazer.txt", mungojerrie);
        documents.put("of-the-awefull-battle-of-the-pekes-and-the-pollicles.txt", awefull);
        documents.put("old-deuteronomy.txt", old);
        documents.put("skimbleshanks-the-railway-cat.txt", skimble);
        documents.put("the-ad-dressing-of-cats.txt", ad);
        documents.put("the-naming-of-cats.txt", naming);
        documents.put("the-old-gumbie-cat.txt", oldGrumbie);
        documents.put("the-rum-tum-tugger.txt", rum);
        documents.put("the-song-of-the-jellicles.txt", song);

        //top10(Doc)
        top10("bustopher-jones-the-cat-about-town.txt", documents);
        top10("gus-the-theater-cat.txt", documents);

        //bst for each document
        BST<String, Term> bustopherBST = new BST<String, Term>();
        Stopwatch one1 = new Stopwatch();
        makeBST("bustopher-jones-the-cat-about-town.txt", documents, bustopherBST);
        System.out.println("Construction of bustopher BST: " + one.elapsedTime() + "s");

        BST<String, Term> growltigersBST = new BST<String, Term>();
        Stopwatch two2 = new Stopwatch();
        makeBST("growltigers-last-stand.txt", documents, growltigersBST);
        System.out.println("Construction of growltigers BST: " + two2.elapsedTime() + "s");

        BST<String, Term> gusBST = new BST<String, Term>();
        Stopwatch three3 = new Stopwatch();
        makeBST("gus-the-theater-cat.txt", documents, gusBST);
        System.out.println("Construction of gus BST: " + three3.elapsedTime() + "s");

        BST<String, Term> macavityBST = new BST<String, Term>();
        Stopwatch four4 = new Stopwatch();
        makeBST("macavity-the-mystery-cat.txt", documents, macavityBST);
        System.out.println("Construction of macavity BST: " + four4.elapsedTime() + "s");

        BST<String, Term> mrBST = new BST<String, Term>();
        Stopwatch five5 = new Stopwatch();
        makeBST("mr-mistoffelees.txt", documents, mrBST);
        System.out.println("Construction of mr mistoffelees BST: " + five5.elapsedTime() + "s");

        BST<String, Term> mungojerrieBST = new BST<String, Term>();
        Stopwatch six6 = new Stopwatch();
        makeBST("mungojerrie-and-rumpelteazer.txt", documents, mungojerrieBST);
        System.out.println("Construction of mungojerrie BST: " + six6.elapsedTime() + "s");

        BST<String, Term> awefullBST = new BST<String, Term>();
        Stopwatch seven7 = new Stopwatch();
        makeBST("of-the-awefull-battle-of-the-pekes-and-the-pollicles.txt", documents, awefullBST);
        System.out.println("Construction of awefull BST: " + seven7.elapsedTime() + "s");

        BST<String, Term> oldBST = new BST<String, Term>();
        Stopwatch eight8 = new Stopwatch();
        makeBST("old-deuteronomy.txt", documents, oldBST);
        System.out.println("Construction of old deuteronomy BST: " + eight8.elapsedTime() + "s");

        BST<String, Term> skimbleBST = new BST<String, Term>();
        Stopwatch nine9 = new Stopwatch();
        makeBST("skimbleshanks-the-railway-cat.txt", documents, skimbleBST);
        System.out.println("Construction of skimble BST: " + nine9.elapsedTime() + "s");

        BST<String, Term> adBST = new BST<String, Term>();
        Stopwatch ten10 = new Stopwatch();
        makeBST("the-ad-dressing-of-cats.txt", documents, adBST);
        System.out.println("Construction of ad BST: " + ten10.elapsedTime() + "s");

        BST<String, Term> namingBST = new BST<String, Term>();
        Stopwatch eleven11 = new Stopwatch();
        makeBST("the-naming-of-cats.txt", documents, namingBST);
        System.out.println("Construction of naming BST: " + eleven11.elapsedTime() + "s");

        BST<String, Term> oldGrumbieBST = new BST<String, Term>();
        Stopwatch twelve12 = new Stopwatch();
        makeBST("the-old-gumbie-cat.txt", documents, oldGrumbieBST);
        System.out.println("Construction of oldGrumbie BST: " + twelve12.elapsedTime() + "s");

        BST<String, Term> rumBST = new BST<String, Term>();
        Stopwatch thirteen13 = new Stopwatch();
        makeBST("the-rum-tum-tugger.txt", documents, rumBST);
        System.out.println("Construction of rum BST: " + thirteen13.elapsedTime() + "s");

        BST<String, Term> songBST = new BST<String, Term>();
        Stopwatch fourteen14 = new Stopwatch();
        makeBST("the-song-of-the-jellicles.txt", documents, songBST);
        System.out.println("Construction of song BST: " + fourteen14.elapsedTime() + "s");
        System.out.println();

//        10 trials - search for random terms in hashes and bsts and time how long it takes
        String[] trials = new String[10];
        String[] trialsBST = new String[10];

        for (int i = 0; i < 10; i++) {
            LinkedList<Term> randomTerms = pick10th(DocFreq);
            Stopwatch timer = new Stopwatch();
            for (Term term : randomTerms) {
                search(term.getWord(), hashList);
            }
            trials[i] = "Trial " + ((int)i+1) + ": " + timer.elapsedTime() + "s";

            Stopwatch timerBST = new Stopwatch();
            for (Term term : randomTerms) {
                searchBST(term.getWord(), hashList);
            }
            trialsBST[i] = "Trial " + ((int)i+1) + ": " + timer.elapsedTime() + "s";

        }

        System.out.println("HashST Trial Times");
        for (String s : trials) {
            System.out.println(s);
        }
        System.out.println();

        System.out.println("BST Trial Times");
        for (String s : trialsBST) {
            System.out.println(s);
        }
        System.out.println();

    }

    public static void docMap(String docName, LinearProbingHashST<String, Term> docHash){
        try {
            File doc = new File("src/data/"+docName);
            Scanner r = new Scanner(doc);

            while (r.hasNextLine()) {
                String[] data = r.nextLine().replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
//                for (String str : data) {
                for (int i = 0; i < data.length; i++) {
                    if(docHash.contains(data[i])){
                        docHash.get(data[i]).updateFrequency();
                    }
                    else{
                        Term term = new Term(data[i], docName);
                        term.updateFrequency();
                        docHash.put(data[i], term);
                    }
                }
            }
            r.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void updateTfId(LinearProbingHashST<String, Term> hash, LinearProbingHashST<String, Term> DocFreq){
        for(Term currentTerm : hash) {
            if (currentTerm != null) {
                currentTerm.calcTfIdScore(DocFreq.get(currentTerm.getWord()).getFrequency());
            }
        }
    }

    public static void search(String key, LinkedList<LinearProbingHashST<String, Term>> hashMega){
        System.out.println("Searching for '" + key + "'...");
        for (LinearProbingHashST<String, Term> doc : hashMega) {
            for (Term term : doc){
                if ((term != null) && (term.getWord().equals(key))){
                    System.out.println("Document: " + term.getDocument() + " | Frequency: " + term.getFrequency() + " | TF-IDF Score: " + term.getTfIdfScore());
                }

            }
        }
        System.out.println("End of search for '" + key + "'");
        System.out.println();
    }

    public static void searchBST(String key, LinkedList<LinearProbingHashST<String, Term>> hashMega){
        System.out.println("Searching for '" + key + "'...");
        for (LinearProbingHashST<String, Term> doc : hashMega){
            for (Term term : doc){
                if ((term != null) && (term.getWord().equals(key))){
                    System.out.println("Document: " + term.getDocument() + " | Frequency: " + term.getFrequency() + " | TF-IDF Score: " + term.getTfIdfScore());
                }
            }
        }
        System.out.println("End of search for '" + key + "'");
        System.out.println();
    }

    public static MinPQ<Term> putIntoPriorityQueue(String docName, LinearProbingHashST<String, LinearProbingHashST<String, Term>> documents){
        MinPQ<Term> pq = new MinPQ<>(documents.get(docName).size());
            for (Term t : documents.get(docName)) {
                if(t != null) {
                    pq.insert(t);
                }
            }
            return pq;
    }

    public static void top10(String docName, LinearProbingHashST<String, LinearProbingHashST<String, Term>> documents){
        MinPQ<Term> pq = putIntoPriorityQueue(docName,documents);
        System.out.println("Top 10 Terms in " + docName + " are:");
        for (int i = 0; i < 10; i++) {
            Term topTerm = pq.delMin();
            System.out.println(topTerm.getWord() + " | TF-IDF Score: " + topTerm.getTfIdfScore());
        }
        System.out.println();

    }

    public static LinkedList<Term> pick10th(LinearProbingHashST<String, Term> doc){
        ArrayList<Term> arr = new ArrayList<Term>();
        LinkedList<Term> output = new LinkedList<Term>();
        int max = doc.size()/10;

        for (Term t : doc){
            if (t != null){
                arr.add(t);
            }
        }

        for (int i = 0; i < max;){
            int index = (int)(Math.random() * arr.size());
            if (output.contains(arr.get(index))){
                continue;
            }
            else {
                output.add(arr.get(index));
                i++;
            }
        }
        return output;
    }

    public static void makeBST(String docName, LinearProbingHashST<String, LinearProbingHashST<String, Term>> documents, BST<String, Term> docBST){
        LinearProbingHashST<String, Term> currentDoc = documents.get(docName);
        for(Term term : currentDoc){
            if (term != null) docBST.put(term.getWord(), term);
        }
    }


}
