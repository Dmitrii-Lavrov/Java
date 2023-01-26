package game;

public class Road extends AbstractObstacle {

    public Road(String name, int distance) {
        super(name, distance);
    }
    
    public boolean overcome(Runnable runnable) {
        int distanceLimit = runnable.getDistanceLimit();
        return distanceLimit >= getDistance();
    }
    
}
