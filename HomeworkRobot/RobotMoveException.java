package HomeworkRobot;



public class RobotMoveException extends Exception {

    private final RobotMapDefault.RobotDefault robot;

    public RobotMoveException(String message, RobotMapDefault.RobotDefault robot) {
        super(message);
        this.robot = robot;
    }

    public RobotMapDefault.RobotDefault getRobot() {
        return robot;
    }
}
