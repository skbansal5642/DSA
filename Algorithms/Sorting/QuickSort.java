import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class QuickSort {
    public static void main(String[] args) {
        // List<Integer> arr = new ArrayList<>(Arrays.asList(2,3,1,4,5,8,9,7));
        List<Integer> arr = new ArrayList<>(Arrays.asList(6,5,8,9,3,10,15,12,16));
        QuickSort qs = new QuickSort(); 
        int arrLength = arr.size();
        qs.quickSort(arr, 0, arrLength-1);
        System.out.println (arr);
    }
    
    void quickSort(List<Integer> arr, int low, int high)
    {
        // If condition is false, means list is empty or having one element only.
        if (low < high) {
            // Set pivot element at its correct position in array
            // It will return the index from where we need to divide array and further re-arrange.
            int newHigh = partition(arr, low, high);
            // Sort the first half
            quickSort(arr, low, newHigh - 1);
            // Sort the second half
            quickSort(arr, newHigh + 1, high);
        }
    }
    
    int partition(List<Integer> arr, int low, int high) {
        // take low and high in a local variable.
        int i = low;
        int j = high;
        
        // Consider pivot as middle
        int mid = (int)Math.floor(high+low/2);
        // int pivot = mid;
        
        // Consider pivot as high
        // int pivot = high;
        
        // Consider pivot as low
        int pivot = low;
        
        // Run loop till low is less than high
        while (i < j) {
            // If high index element is greater than pivot element, 
            // do nothing keep going upwards in array.
            while (arr.get(pivot) < arr.get(j)) {
                j--;
            }
            // If low index element is lesser than pivot element,
            // do nothing and keep going downwards in array.
            while (arr.get(pivot) > arr.get(i)) {
                i++;
            }
            // Once we found indexes, swap the element
            if (i < j) {
                swap(arr, i, j);
            }
        }
        // Once low becomes greater than high, swap high index element with pivot
        if (i > j) {
            swap(arr, pivot, j);
        }
        // return the low index element.
        return i;
    }
    
    void swap(List<Integer> arr, int index1, int index2) {
        int temp = arr.get(index1);
        arr.set(index1, arr.get(index2));
        arr.set(index2, temp);
    }
}