package Robot;


public class Main {

    public static void main(String[] args) throws ValidationMap {
        // Есть двумерная карта с роботами
        // Роботы это объекты, они могут перемещаться по карте
        // Карта имеет какие-то границы
        // 2 робота не могут находиться в одной точке одновременно
        // Роботы имеют направление (которое можно менять (поворачивать)),
        //              роботы идут только вперед (или стоят на месте).

//        RobotMap.Robot robot = new RobotMap.Robot();
        //  0, 0                  0, n   -> <-
        //  1, 0                  1, n


        // m, 0                    m, n
        //

//        Scanner scanner = new Scanner(System.in);
//        RobotMap map = null;
//
//        System.out.println("Введите размер поля: (2 числа через пробел)");
//        int n = scanner.nextInt();
//        int m = scanner.nextInt();
//        try {
//            map = new RobotMap(n, m);
//        } catch (IllegalArgumentException e) {
//            System.err.println("Не удалось создать карту: " + e.getMessage());
//            System.out.println("Попробуйте еще раз");
//        }
        
        RobotMap map = new RobotMap(100, 90, 2);
        try {
            RobotMap.Robot robot1 = map.createRobot(new Point(8, 2));
            System.out.println(robot1);
        } catch (RobotCreationException e) {
            System.err.println("Не удалось создать робота!");
        }
        try {
            RobotMap.Robot robot2 = map.createRobot(new Point(4, 1)); // Direction = Direction.TOP
            System.out.println(robot2);
            RobotMap.Robot robot3 = map.createRobot(new Point(4, 1));
            System.out.println(robot3);            
            robot2.go();
            System.out.println(robot2);            
        } catch (RobotCreationException e) {
            System.err.println("Не удалось создать робота!");
        } catch (RobotMoveException e) {
            System.err.println("Не удалось сдвинуть робота с места!");
        }
    }

    // private void homework() {
    //     // 0. Добавить проверку входных данных в конструкторе RobotMap
    //     // 1. Доработать класс карты: запретить одновременное нахождение какого-то количества робов на карте.
    //     //    Ограничение в 10 роботов.
    //     // 2. Задать возможность вызова #move на заданное количество единиц.
    //     //    Метод без аргументов перемещает на 1 единицу.    
    // }

}
