package game;

public abstract class AbstractObstacle {
    
    private final String name;
    private final int distance;

    public AbstractObstacle(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}
