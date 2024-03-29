package HomeworkRobot;
import java.util.*;



public class Main {

    public static void main(String[] args) {
        // Есть двумерная карта с роботами
        // Роботы это объекты, они могут перемещаться по карте
        // Карта имеет какие-то границы
        // 2 робота не могут находиться в одной точке одновременно
        // Роботы имеют направление (которое можно менять (поворачивать)),
        // роботы идут только вперед (или стоят на месте).

        Scanner userInput = new Scanner(System.in);

        System.out.println("Добро пожаловать в игру!");
        System.out.println("...описание...");
        
        RobotMapFactory robotMapFactory = new RobotMapFactory(); 

        RobotMap map;
        while (true) {
            System.out.println("Для создания карты введите 2 положительных числа через пробел");
            try {
                int n = userInput.nextInt();
                int m = userInput.nextInt();
                userInput.nextLine();

                map = robotMapFactory.create(n, m);
                break;
            } catch (RobotMapCreationException | InputMismatchException e) {
                System.err.println("Возникла ошибка при создании карты: " + e.getMessage());
            } catch (Throwable e) {
                System.err.println("Возникла ошибка на стороне сервера: " + e.getMessage());
                System.exit(1);
            }
        }

        System.out.println("Карта успешно создана!");

        CommandManager commandManager = new CommandManager(map);

        System.out.println("Для просмотра списка допустимых команд введите h");

        while (true) {
            System.out.println("Введите команду");
            String command = userInput.nextLine();
            try {
                String commandExecutionResult = commandManager.handleCommand(command);

                if (Objects.nonNull(commandExecutionResult) && !commandExecutionResult.isBlank()) {
                    System.out.println(commandExecutionResult);
                }
            } catch (CommandNotFoundException e) {
                System.err.println("Команда [" + e.getMessage() + "] не найдена");
            } catch (CommandExecutionException e) {
                System.err.println("Во время исполнения команды произошла ошибка: " + e.getMessage());
            }
        }

    }

    private static class CommandManager {
        Direction direction;
        private final RobotMap map;
        private final Map<String, CommandExecutor> commands;

        public CommandManager(RobotMap map) {
            this.map = map;
            commands = new HashMap<>();
            commands.put("h", this::printHelp);
            commands.put("q", this::quit);
            commands.put("a", this::addRobot);
            commands.put("m", this::moveRobot);
            commands.put("l", this::listRobots);
            commands.put("cd", this::changeDirectionRobot);
            
        }

        public String handleCommand(String command) throws CommandNotFoundException, CommandExecutionException {
            String[] split = command.split(" ");
            String commandCode = split[0];

            CommandExecutor executor = commands.get(commandCode);
            if (executor == null) {
                throw new CommandNotFoundException(command);
            }

            String[] args = Arrays.copyOfRange(split, 1, split.length);
            return executor.execute(args);
        }

        private String addRobot(String[] args) throws CommandExecutionException {
            if (args.length < 2) {
                throw new CommandExecutionException("Недостаточно аргументов");
            }

            int x = Integer.parseInt(args[0]);
            int y = Integer.parseInt(args[1]);

            try {
                map.createRobot(new Point(x, y));
                
            } catch (RobotCreationException e) {
                throw new CommandExecutionException(e.getMessage());

            }

            return null;
        }

        private String moveRobot(String[] args) throws CommandExecutionException {
            if (args.length < 2) {
                throw new CommandExecutionException("Недостаточно аргументов");
            }

            Long id = Long.parseLong(args[0]);
            int l = Integer.parseInt(args[1]);

            try {
                map.findRobot(id).move(l);
            } catch (RobotMoveException e) {
                throw new CommandExecutionException(e.getMessage());
            }
            
            return null;
        }

        private String changeDirectionRobot(String[] args) throws CommandExecutionException {
            if (args.length < 2 ) {
                throw new CommandExecutionException("Недостаточно аргументов");
            }

            Long id = Long.parseLong(args[0]);
            String d = args[1];
            

            if (d.equals("t")) {
                direction = Direction.TOP;
            } else if (d.equals("r")) {
                direction = Direction.RIGHT;
            } else if (d.equals("b")) {
                direction = Direction.BOTTOM;
            } else if (d.equals("l")) {
                direction = Direction.LEFT;
            } else {
                throw new CommandExecutionException("Неверно указано направление!");
            }       
            map.findRobot(id).changeDirection(direction);            
            
            return null;
        }

        private String listRobots(String[] args) {
            return String.valueOf(map.getList());
            
        }

        private String printHelp(String[] args) {
            return """
                    h                  -> распечатать список допустимых команд (help)
                    a 1 2              -> создать робота на позиции (1, 2) (add)
                    l                  -> распечатать всех роботов (list)
                    m id [5]           -> перемещаем робота на 1 единицу вперед (move)
                    cd id [t, r, b, l] -> изменить направление робота (change direction)
                    q                  -> завершить программу (quit)
                    """;
        }

        private String quit(String[] args) {
            System.exit(0);
            return null;
        }

        private interface CommandExecutor {
            String execute(String[] args) throws CommandExecutionException;
        }

    }    

}
