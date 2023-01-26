package game;

public class Wall extends AbstractObstacle {

    public Wall(String name, int distance) {
        super(name, distance);
    }

    public boolean overcome(JumpableUp jumpableUp) {
        int jumpLimit = jumpableUp.getJumpLimitUp();
        return jumpLimit >= getDistance();
    }    
}
