package Robot;

import java.util.*;

public class RobotMap {

    private final int n;
    private final int m;
    private final int maxRobotCount;
    public final List<Robot> robots;

    public RobotMap(int n, int m, int maxRobotCount) throws ValidationMap {
        this.n = n;
        this.m = m;
        this.maxRobotCount = maxRobotCount;
        validateMap();
        this.robots = new ArrayList<>();
    }

    public Robot createRobot(Point point) throws RobotCreationException {
        final MapPoint robotPosition;
        try {
            validatePoint(point);
            validateNumber();
            robotPosition = new MapPoint(point.getX(), point.getY());
        } catch (PointValidationException e) {
            throw new RobotCreationException(e.getMessage());
        }
        


        
        Robot robot = new Robot(robotPosition);
        robots.add(robot);
        return robot;
    }

    private void validatePoint(Point point) throws PointValidationException {
        validatePointIsFree(point);
    }

    private void validateNumber() throws PointValidationException {
        if (robots.size() == maxRobotCount) {
            throw new PointValidationException("Превышено допустимое количество роботов на карте!");
        }
    }

    private void validateMap() throws ValidationMap {
        if (m < 1 || n < 1 || maxRobotCount < 0) {
            throw new ValidationMap("Указаны некорректые размеры карты, либо некорретное количество роботов!");
        }
    }

    private void validatePointIsFree(Point point) throws PointValidationException {
        for (Robot robot : robots) {            
            if (point.equals(robot.getPoint())) {
                throw new PointValidationException("Позиция " + point + " занята другим роботом: " + robot);
            }
        }
    }

    public class Robot {

        public static final Direction DEFAULT_DIRECTION = Direction.TOP;
        private int l;
        private final UUID id;
        private MapPoint point;
        private Direction direction;

        public Robot(MapPoint point) {
            this.id = UUID.randomUUID();
            this.point = point;
            this.direction = DEFAULT_DIRECTION;
        }

        public void go(int l) throws RobotMoveException {
            this.l = l; 
            move(l);
        }
        public void go() throws RobotMoveException {
            this.l = 1; 
            move(l);
        }

        public void move(int l) throws RobotMoveException {
            this.l = l;         
            final MapPoint newPoint;
            try {
                if (direction == Direction.TOP) {
                        newPoint = new MapPoint(point.getX() - l, point.getY());
                    }
                    else if (direction == Direction.RIGHT) {
                        newPoint = new MapPoint(point.getX(), point.getY() + l);
                    }
                    else if (direction == Direction.BOTTOM) {
                        newPoint = new MapPoint(point.getX() + l, point.getY());
                    }
                    else   {
                        newPoint = new MapPoint(point.getX(), point.getY() - l);
                    }

                validatePoint(newPoint);
            } catch (PointValidationException e) {
                throw new RobotMoveException(e.getMessage(), this);
            }

            this.point = newPoint;
        }

       
        public void changeDirection(Direction direction) {
            this.direction = direction;
        }

        public MapPoint getPoint() {
            return point;
        }

        @Override
        public String toString() {
            return "Robot-" + id + point;
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