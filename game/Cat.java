package game;

public class Cat extends Participant {

    public Cat(String name, int distanceLimit, int jumpLimitUp, int jumpLimitForward) {
        super(name, distanceLimit, -1, jumpLimitUp, jumpLimitForward);
    }

}