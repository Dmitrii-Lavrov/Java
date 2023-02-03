package HomeworkRobot;

public interface Robot {    
    
    void move(int l) throws RobotMoveException; 
    void changeDirection(Direction direction);
    Point getPoint();
    Long getID();
}
