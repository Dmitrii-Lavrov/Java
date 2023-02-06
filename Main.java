public class Main {

    public static void main(String[] args) {
        // Есть машина, которая умеет делать круглые отверстия для круглых колышков (RoundPeg).
        // Также у нас есть квадратные колышки (SquareSide).
        // Задача: научить машину делать отверстия для квадратных колышков (реализовать паттерн адаптер).
        // Нужно "адаптировать" интерфейс SquarePeg под интерфейс RoundPeg

        RoundPegHoleMachine machine = new RoundPegHoleMachine();        
        RoundPeg peg = new DefaultRoundPeg(2.0);
        System.out.println(peg.radius());  // 2.0  
        RoundHole hole = machine.create(peg);
        System.out.println(hole.radius()); // 2.0     
        SquarePeg peg2 = new DefaultSquarePeg(5.0);
        System.out.println(peg2.side()); // 5.0               
        RoundHoleAdapter roundHoleAdapter = new RoundHoleAdapter(peg2);        
        RoundHole squareHole = machine.create(roundHoleAdapter);
        // double r = squareHole.radius();
        System.out.printf("%.4f", squareHole.radius()); // ~ 3.5355 
              
    }

    static class RoundPegHoleMachine {
        public RoundHole create(RoundPeg peg) {
            return new DefaultRoundHole(peg.radius());
        }
    }
    
    static class RoundHoleAdapter implements RoundPeg, SquarePeg {
        
        private SquarePeg peg;       

        public RoundHoleAdapter(SquarePeg peg) {        
            this.peg = peg;
        }
        
        @Override
        public double radius() {       
        return Math.sqrt(2*Math.pow(peg.side(), 2))/2;
        }       

        @Override
        public double side() {
        return peg.side();
        }

    }
    
    static class DefaultRoundHole implements RoundHole {
        private final double radius;
        public DefaultRoundHole(double radius) {
            this.radius = radius;
        }
        public double radius() {
            return radius;
        }        
    }    
    
    static class DefaultRoundPeg implements RoundPeg {
        private final double radius;
        public DefaultRoundPeg(double radius) {
            this.radius = radius;
        }
        @Override
        public double radius() {
            return radius;
        }
    }   

    static class DefaultSquarePeg implements SquarePeg {
        private final double side;
        public DefaultSquarePeg(double side) {
            this.side = side;
        }
        @Override
        public double side() {
            return side;
        }
    }

    interface SquarePeg {
        double side();
    }

    interface RoundPeg {
        double radius();
    }

    interface RoundHole {
        double radius();
    }
}
