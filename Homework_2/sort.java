package Homework_2;
public class sort {
    public static void main(String args[]){
        int arr[] = {15, 7, 18, 5, 2, 1};
        Sort(arr); 
        printArray(arr);
        
    }      
    
    public static void Sort(int arr[]){      
        
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while(j >= 0 && key < arr[j]) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }  
    }     
    static void printArray(int arr[]){
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
}
