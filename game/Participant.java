package game;

public abstract class Participant implements Runnable, JumpableUp, Swimmable, JumpableForward {

    private final String name;
    private final int distanceLimit;
    private final int swimLimit;
    private final int jumpLimitUp;
    private final int jumpLimitForward;

    public Participant(String name, int distanceLimit, int swimLimit, int jumpLimitUp, int jumpLimitForward) {
        this.name = name;
        this.distanceLimit = distanceLimit;
        this.swimLimit = swimLimit;
        this.jumpLimitUp = jumpLimitUp;
        this.jumpLimitForward = jumpLimitForward;
    }

    public String getName() {
        return name;
    }

    @Override
    public int getDistanceLimit() {
        return distanceLimit;
    }

    @Override
    public int getSwimLimit() {
        return swimLimit;
    }

    @Override
    public int getJumpLimitUp() {
        return jumpLimitUp;
    }

    @Override
    public int getJumpLimitForward() {
        return jumpLimitForward;
    }
}
