package HomeworkRobot;

public class RobotMapFactory {

    public RobotMap create(int m, int n) throws RobotMapCreationException {
        return new RobotMapDefolt(n, m);
    }

}
