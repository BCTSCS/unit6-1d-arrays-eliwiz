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

    public static void main(String[] args){
        int[] arr = {10,20,30,40,50};
        System.out.println(searchlist(arr, 10));
    }
}