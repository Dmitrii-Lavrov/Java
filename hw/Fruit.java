package hw;

public class Fruit {

    public  double weight;

    public Fruit(double weight) {
        this.weight = weight;
    }

    public  double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return String.valueOf(getWeight());
    }
}
