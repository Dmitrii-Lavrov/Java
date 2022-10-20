package Homework_2;
public class hanoy {
    public static void main(String args[]){
        hanoi(3, 1, 2); 
    }      
    
    public static void hanoi(int n, int i, int k){       
     // n - это количество дисков   
        if (n == 1){
            System.out.printf("\n" + "Move disk %d from pin %d to %d", n, i, k);                  
        }
        else{ 
            int l = 6 - i - k; // i, k, l - номера стержней           
            hanoi(n-1, i, l);
            System.out.printf("\n" + "Move disk %d from pin %d to %d", n, i, k);            
            hanoi(n-1, l, k);            
        }
    }
}