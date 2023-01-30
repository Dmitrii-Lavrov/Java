package hw;

import java.util.List;
import java.util.ArrayList;

public class Box<E extends Fruit> {

    // Реализовать хранение фруктов в коробке.
    // Должны быть доступны следующие возможности
    // Добавление фрукта
    // Должен быть конструктор
    // Метод, который пересыпает фрукты из текущей коробки в другую коробку
    // Для внутреннего хранения можно использовать например List

    private List<E> list = new ArrayList<>();

    public void add(E fruit) {
        list.add(fruit);
    }

    public double getSumWeight() {
        double sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum = sum + list.get(i).getWeight();           
        }
        return sum;
    }

    public void moveTo(Box<? super E> anotherBox) {
        for (int i = 0; i < list.size(); i++) {
            anotherBox.add(list.get(i));
            list.remove(i);
        }
    }
    public List<E> getList(){
        return list;
    }

    @Override
    public String toString() {
        return String.valueOf(list);
    }

}
