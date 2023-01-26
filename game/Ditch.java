package game;

public class Ditch extends AbstractObstacle {

    public Ditch(String name, int distance) {
        super(name, distance);
    
    }
    
    public boolean overcome(JumpableForward jumpableForward) {
        int distanceLimit = jumpableForward.getJumpLimitForward();
        return distanceLimit >= getDistance();
    }
}
