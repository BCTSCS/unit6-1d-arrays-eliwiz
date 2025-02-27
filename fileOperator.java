import java.io.IOException;
import java.io.File;
import java.util.*;

public class fileOperator{

    public ArrayList<Integer> toStringList(Scanner file){
        ArrayList<String> list = new ArrayList<String>();
        while (file.hasNext()){
            list.add(file.nextLine());
        }
        return list;
    }

    public ArrayList<Integer> toIntList(Scanner file){
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (file.hasNextInt()){
            list.add(file.nextInt());
        }
        return list;
    }
    public static String[] fileToStringArray(int length, Scanner file){
        String[] arr = new String[length];
        for(int i=0; i<length; i++){
            arr[i]=file.nextLine();
        }
        return arr;

    }
     public static int[] fileToIntArray(int length, Scanner file){
        int[] arr = new int[length];
        for(int i=0; i<length; i++){
            arr[i]=file.nextInt();
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


    //analytical: Find Albums by Artist

    public static String[] findAlbumByArtist(String artist, String[] arr, String[] album){
        int count = 0;
        String artistIndex = "";

        for(int i = 0; i < arr.length; i++){
            if (arr[i].equals(artist)){
                count++;
                artistIndex= artistIndex + i+";";
            }
        }

        String[] albums = new String[count];

        String specificAlbum="";
        for (int i = 0; i<count; i++){
            specificAlbum = artistIndex.substring(0,specificAlbum.indexOf(';'));

        }

        return count;
    }

    //Statistical: Most Common Genre 
    public static String mostCommonGenre(String[] arr){
        String visited= "";
        String maxWord="";
        int maxNum=0;

        for (String word : arr){
            if(visited.indexOf(word) == -1){
                visited = visited + word +";";
                int wordCount = count(word, arr);
                if (wordCount>maxNum){
                    maxNum = wordCount;
                    maxWord = word;
                }

            }
        }
        return maxWord;
    }

    public static int count(String word, String[] arr){
        int count=0;
        for (String w : arr){
            if(w.equals(word)){
                count++;
            }
        }
        return count;
    }


    public static void main(String[] args){

        try{
            File f= new File("artists.txt");
            Scanner artistInput = new Scanner(f);

            String[] artistArray = fileToStringArray(20, artistInput);
            for (String num : artistArray){
                System.out.print(num + "; ");
            }

            File k= new File("albums.txt");
            Scanner albumInput = new Scanner(k);
            String[] albumArray = fileToStringArray(20, albumInput);


        }catch(IOException e ){
            System.out.println("file not found");
        }

    }
}