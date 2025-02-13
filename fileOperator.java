import java.io.IOException;
import java.util.Scanner;
import java.io.File;

public class fileOperator{

    public static int[] fileToIntArray(int length, Scanner file){
        int[] arr = new int[length];
        for(int i=0; i<length; i++){
            arr[i]=file.nextInt();
        }
        return arr;

    }
    public static String[] fileToStringArray(int length, Scanner file){
        String[] arr = new String[length];
        for(int i=0; i<length; i++){
            arr[i]=file.nextLine();
        }
        return arr;

    }
    public static double[] fileToDoubleArray(int length, Scanner file){
        double[] arr = new double[length];
        for(int i=0; i<length; i++){
            arr[i]=file.nextDouble();
        }
        return arr;

    }
    public static void main(String[] args){

        try{
            File f= new File("artists.txt");
            Scanner input = new Scanner(f);

            String[] newArray = fileToStringArray(20, input);
            for (String num : newArray){
                System.out.print(num + "; ");
            }

        }catch(IOException e ){
            System.out.println("file not found");
        }

    }
}