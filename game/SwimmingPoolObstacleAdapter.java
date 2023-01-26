package game;

public class SwimmingPoolObstacleAdapter implements Obstacle {

    private final SwimmingPool distance;

    public SwimmingPoolObstacleAdapter(SwimmingPool distance) {
        this.distance = distance;
    }

    @Override
    public boolean overcome(Participant participant) {
        return distance.overcome(participant);
    }

    @Override
    public String type() {
        return "Бассейн";
    }
}