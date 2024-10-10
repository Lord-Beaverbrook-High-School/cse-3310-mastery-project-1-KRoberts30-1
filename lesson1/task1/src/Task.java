import java.util.Arrays;

public class Task {
    public static void main(String[] args) {
        int[] arr = new int[10];
        //populates array randomly
        populate(arr);
        sort(arr, 0, arr.length - 1);
        //prints sorted array
        System.out.println("");
        System.out.println("Sorted array");
        print(arr);

    }
    public static void populate(int[] arr){
        //populates array
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)Math.round(Math.random() * 10);
        }
    }
    public static void sort(int[] arr, int low, int high) {
        print(arr);
        System.out.println("");
        if (low >= high) {
            //deals with subarray of one
            return;
        }
        //rightmost index of array
        int pivot = arr[high];
        //pointer to find numbers bigger than pivot
        int leftPoint = low;
        //pointer to find numbers lower than pivot
        int rightPoint = high;
        while (leftPoint < rightPoint) {
            //continues until the right and left pointers hit one another
            while (arr[leftPoint] <= pivot && leftPoint < rightPoint) {
                //if a number at the left pointer's index is greater than the pivot and the left pointer is greater or equal to the right pointer, then
                //the while loop breaks.
                //otherwise run the code inside the while loop
                leftPoint++;
            }
            while (arr[rightPoint] >= pivot && rightPoint > leftPoint) {
                //opposite of previous while loop
                rightPoint--;
            }
            //continues swapping numbers as needed until pointers hit one another
            swap(arr, leftPoint, rightPoint);
        }
        //resets pivot to index at the end of the array/subarray
        swap(arr, leftPoint, high);
        //resets pointers
        sort(arr, low, leftPoint - 1);
        sort(arr, leftPoint + 1, high);
    }
    public static void swap(int[] arr, int i, int j) {
        //swapping method
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void print(int[] arr) {
        for (int k = 0; k < arr.length; k++) {
            System.out.print(arr[k] + ", ");
        }
        System.out.println("");
    }
}
//source https://www.youtube.com/watch?v=h8eyY7dIiN4
//testing
// - print instances of sorting method to trace how the array is being sorted
//checking if quicksort is how the array is sorted ^^