package HomeworkRobot;
public class RobotMoveException extends Exception {

    private final RobotMapDefolt.Robot robot;

    public RobotMoveException(String message, RobotMapDefolt.Robot robot) {
        super(message);
        this.robot = robot;
    }

    public RobotMapDefolt.Robot getRobot() {
        return robot;
    }
}
