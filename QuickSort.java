import java.util.Arrays;

public class QuickSort {

    public static void quickSort(int[] array, int min, int max) {
        if (array.length == 0)
            return;//завершить выполнение если длина массива равна 0
 
        if (min >= max)
            return;//завершить выполнение если уже нечего делить
 
        // выбрать опорный элемент
        int middle = min + (max - min) / 2;
        int opora = array[middle];
 
        // разделить на подмассивы, который больше и меньше опорного элемента
        int i = min, j = max;
        while (i <= j) {
            while (array[i] < opora) {
                i++;
            }
 
            while (array[j] > opora) {
                j--;
            }
 
            if (i <= j) {//меняем местами
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
 
        // вызов рекурсии для сортировки левой и правой части
        if (min < j)
            quickSort(array, min, j);
 
        if (max > i)
            quickSort(array, i, max);
    }
    public static void main(String[] args) {
        int[] x = { 1, 34, 0, 56, 7, 3, 9, 30, 15, 93 };        
        System.out.println(Arrays.toString(x));
 
        int low = 0;
        int high = x.length - 1;
 
        quickSort(x, low, high);       
        System.out.println(Arrays.toString(x));
    }
}
