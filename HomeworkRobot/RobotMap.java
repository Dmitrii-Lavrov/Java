package HomeworkRobot;

import java.util.List;

import HomeworkRobot.RobotMapDefolt.Robot;

public interface RobotMap {           

    Robot createRobot(Point point) throws RobotCreationException;

    Robot findRobot(Long id) throws CommandExecutionException;

    List<Robot> getList();
}
