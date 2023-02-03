package HomeworkRobot;
import java.util.*;

public class RobotMapDefault implements RobotMap {

    private final int n;
    private final int m;
    public final List<Robot> robots;
    private Robot robot;

    public RobotMapDefault(int n, int m) throws RobotMapCreationException {
        if (n < 0 || m < 0) {
            throw new RobotMapCreationException("Некоректный размер карты");
        }

        this.n = n;
        this.m = m;
        this.robots = new ArrayList<>();
    }

    public Robot createRobot(Point point) throws RobotCreationException {
        final MapPoint robotPosition;
        try {
            validatePoint(point);
            robotPosition = new MapPoint(point.getX(), point.getY());
        } catch (PointValidationException e) {
            throw new RobotCreationException(e.getMessage());
        }

        Robot robot = new RobotDefault(robotPosition);
        robots.add(robot);        
        System.out.println("Добавлен новый робот" + robot);
        return robot;
    }

    public Robot findRobot(Long id) throws CommandExecutionException {
    if (id > robots.size() || id < 1) {
                throw new CommandExecutionException("Такого робота нет!");
            }

        for (int i = 0; i < robots.size(); i++) {
            if (id == robots.get(i).getID()) {    //id == robots.get(i).id
                this.robot = robots.get(i);    
                break;                                  
            }                    
        }
        return robot;
    }

    public List<Robot> getList(){
        return robots;
    }

    private void validatePoint(Point point) throws PointValidationException {
        validatePointIsFree(point);
    }

    private void validatePointIsFree(Point point) throws PointValidationException {
        for (Robot robot : robots) {
            if (point.equals(robot.getPoint())) {//point.equals(robot.getPoint())
                throw new PointValidationException("Позиция " + point + " занята другим роботом: " + robot);
            }
        }
    }

    public class RobotDefault implements Robot {
        
        public static final Direction DEFAULT_DIRECTION = Direction.TOP;

        private static Long idSequence = 1L;       
        public final Long id;
        private MapPoint point;
        public Direction direction;

        public RobotDefault(MapPoint point) {
            this.id = idSequence++; //UUID.randomUUID();
            this.point = point;
            this.direction = DEFAULT_DIRECTION;
        }
        
        public void move(int l) throws RobotMoveException {
            
            final MapPoint newPoint;
            try {
                newPoint = switch (direction) {
                    case TOP -> new MapPoint(point.getX() - l, point.getY());
                    case RIGHT -> new MapPoint(point.getX(), point.getY() + l);
                    case BOTTOM -> new MapPoint(point.getX() + l, point.getY());
                    case LEFT -> new MapPoint(point.getX(), point.getY() - l);
                };

                validatePoint(newPoint);
            } catch (PointValidationException e) {
                throw new RobotMoveException(e.getMessage(), this);
            }

            this.point = newPoint;
            System.out.println("robot-" + id + " перемещен на точку: " + point);
        } 

        public void changeDirection(Direction direction) {            
            this.direction = direction;      
            System.out.println(robot + " изменил направление на: " + direction);      
        }

        public MapPoint getPoint() {
            return point;
        }

        public Long getID() {
            return id;
        }

        @Override
        public String toString() {
            return "[Робот-" + id + "] точка " + point;
        }
    }

    public class MapPoint extends Point {

        public MapPoint(int x, int y) throws PointValidationException {
            super(x, y);

            if (x < 0 || x > n || y < 0 || y > m) {
                throw new PointValidationException("Недопустимое значение Point: " + this);
            }
        }
    }

}
