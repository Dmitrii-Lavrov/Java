package game;

public class DitchObstacleAdapter implements Obstacle {

    private final Ditch ditch;

    public DitchObstacleAdapter(Ditch ditch) {
        this.ditch = ditch;
    }

    @Override
    public boolean overcome(Participant participant) {
        return ditch.overcome(participant);
    }

    @Override
    public String type() {
        return "Канава";
    }
}

