import java.util.Comparator;

public class Egg implements Comparable<Egg>{

    private String animal;
    private double width; //in inches
    private double weight; //in ounces

    public Egg(String animal, double width, double weight){
        this.animal = animal;
        this.width = width;
        this.weight = weight;
    }

    public String getAnimal(){
        return animal;
    }

    public double getWidth(){
        return width;
    }

    public double getWeight(){
        return weight;
    }

    public int compareTo(Egg o) {
        if (weight < o.weight)
            return -1;
        else if (weight > o.weight)
            return +1;
        return 0;
    }



}
