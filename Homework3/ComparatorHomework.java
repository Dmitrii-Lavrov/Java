package Homework3;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class ComparatorHomework {

    public static void main(String[] args) {
        // 1. Создать список объектов типа Notebook
        List<Notebook> notebooks = new ArrayList<>();
        Notebook notebook1 = new Notebook(2, 70000);
        notebooks.add(notebook1);
        Notebook notebook2 = new Notebook(3, 60000);
        notebooks.add(notebook2);
        Notebook notebook3 = new Notebook(4, 50000);
        notebooks.add(notebook3);
        Notebook notebook4 = new Notebook(2, 25000);
        notebooks.add(notebook4);
        System.out.println("Неотсортированный список");
        System.out.println(notebooks);  
        // Отсортировать его тремя способами:
        // 1.1 по ОЗУ (ram)

        Comparator<Notebook> RamComparator = (n1, n2) -> Integer.compare(n1.getRam(),n2.getRam());

        // 1.2 по цене (price)

        Comparator<Notebook> PriceComparator = (n1, n2) -> Double.compare(n1.getPrice(), n2.getPrice());

        // 1.3 сначала по ram, потом по price (если ram не равны, сортируем по ним; если
        // равны, то по цене)
        Comparator<Notebook> RamPriseComparator = new Comparator<Notebook>() {

            @Override
            public int compare(Notebook n1, Notebook n2) {
                int result = Integer.compare(n1.getRam(), n2.getRam());
                if (result != 0) {
                    return result;
                }
                return Double.compare(n1.getPrice(), n2.getPrice());
            }
        };

        Collections.sort(notebooks, RamComparator);
        System.out.println("Сортировка по ОЗУ");
        System.out.println(notebooks);
        Collections.sort(notebooks, PriceComparator);
        System.out.println("Сортировка по цене");
        System.out.println(notebooks);
        Collections.sort(notebooks, RamPriseComparator);
        System.out.println("Сортировка по ОЗУ и цене");        
        System.out.println(notebooks);      
    }

    private static class Notebook {

        private final int ram;
        private final double price;

        public Notebook(int ram, double price) {
            this.ram = ram;
            this.price = price;
        }

        public int getRam() {
            return ram;
        }

        public double getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return "[ОЗУ: " + ram + ", Цена: " + price + "]";
        }
    }
}    