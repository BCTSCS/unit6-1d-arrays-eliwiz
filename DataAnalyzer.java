import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.io.FileReader;

public class DataAnalyzer{

    public static int binarylist(int[] numbers, int target){
        int left=0;
        int right=numbers.length-1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (numbers[mid] == target) {
                return mid; 
            } else if (numbers[mid] < target) {
                left = mid + 1; 
            } else {
                right = mid - 1; 
            }
        }

        return -1;
        
    }

    public static int searchlist(int[] numbers, int target){
        int index=0;
        while (index<=numbers.length-1){
            if (numbers[index] == target){
                return index;
            }
            index++;
        }
        return -1;
    }

    public static int[] reverseArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        return arr;
}

    public static int[] fileToArray(int length, Scanner file){
        int[] arr = new int[length];
        for(int i=0; i<length; i++){
            arr[i]=file.nextInt();
        }
        return arr;

    }
    public static void main(String[] args){
        int[] arr = {10,20,30,40,50};
        System.out.println(searchlist(arr, 10));

        try{
            File f= new File("numbers.txt");
            Scanner input = new Scanner(f);
            
            int[] newArray = fileToArray(100, input);
            System.out.println("Finding number 17 with searchlist: " + searchlist(newArray,17));
            System.out.println("Finding number 17 with binary: " + binarylist(newArray,17));
            System.out.println("Reversed List: ");
            for (int num : newArray){
                System.out.print(num + " ");
            }

        }catch(IOException e ){
            System.out.println("file not found");
        }

    }
}