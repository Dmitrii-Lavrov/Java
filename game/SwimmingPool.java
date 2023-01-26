package game;

public class SwimmingPool extends AbstractObstacle {

    public SwimmingPool(String name, int distance) {
        super(name, distance);
    }
    
    public boolean overcome(Swimmable swimmable) {
        int swimLimit = swimmable.getSwimLimit();
        return swimLimit >= getDistance();
    }
   
}

