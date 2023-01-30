package hw;

public class HomeworkMain {

    public static void main(String[] args) {
      //  Box<String> stringBox = new Box(); // запрещено!
//
       Box<Apple> apples = new Box<>();
       apples.add(new Apple(1.0));       
       apples.add(new Apple(2.0));
       apples.add(new Apple(3.0));
      //  apples.add(new Orange(3.0)); // запрещено!!!
       apples.add(new GoldenApple(3.0)); // разрешено
       System.out.print("Коробка с яблоками: ");
       System.out.println(apples);       
      //  System.out.println(apples.getSumWeight()); // 9.0

       Box<Orange> orangeBox = new Box<>();
       orangeBox.add(new Orange(1.0));
      //  orangeBox.add(new Apple(1.0)); // запрещено!!!
      System.out.print("Всего апельсинов в коробке Апельсины: "); 
      System.out.println(orangeBox.getSumWeight()); // 1.0

       Box<GoldenApple> goldenAppleBox = new Box<>();
       goldenAppleBox.add(new GoldenApple(2.0));
      //  goldenAppleBox.add(new Apple(2.0)); // запрещено!
       System.out.print("Всего яблок сорта Голден в коробке Яблоки Голден: ");
       System.out.println(goldenAppleBox.getSumWeight()); // 2.0
       System.out.print("Всего яблок в коробке Яблоки: ");
       System.out.println(apples.getSumWeight()); // 9.0
       System.out.println("Пересыпаем яблоки сорта Голден в коробку Яблоки");       
       goldenAppleBox.moveTo(apples); // можно
       System.out.print("Всего яблок сорта Голден в коробке Яблоки Голден: ");
       System.out.println(goldenAppleBox.getSumWeight()); // 0.0
       System.out.print("Всего яблок в коробке Яблоки:  ");
       System.out.println(apples.getSumWeight()); // 9.0 + 2.0 = 11.0

      //  apples.moveTo(goldenAppleBox); // нельзя!
      //  orangeBox.moveTo(apples); // нельзя
    }

}
