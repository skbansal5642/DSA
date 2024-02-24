import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class MergeSort {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(9,3,7,5,6,4,8,2));
        MergeSort ms = new MergeSort(); 
        int arrLength = arr.size();
        ms.mergeSort(arr, 0, arrLength-1);
        System.out.println (arr);
    }
    
    void mergeSort(List<Integer> arr, int low, int high)
    {
        // int count = (int)Math.ceil(Math.log(high)/Math.log(2));

        // If condition is false, means list is empty or having one element only.
        if (low < high) {
            // Calculate the mid index of array.
            int mid = (int)Math.floor((low + high) / 2);
            // Recall function for first half of array
            mergeSort(arr, low, mid);
            // Recall function for second half of array
            mergeSort(arr, mid+1, high);
            // Sort and merge both the first and second half of array.
            merge(arr, low, mid, high);
        }
    }
    
    void merge(List<Integer> arr, int low, int mid, int high) {
        // Create 2 dynamic list
        List<Integer> arr1 = new ArrayList<Integer>();  
        List<Integer> arr2 = new ArrayList<Integer>();

        // Get value from main array as per low, mid & high
        // and fill them into sub-arrays.
        for (int index = low; index <= mid; index++) { 
            arr1.add(arr.get(index));
        }
        for (int index = mid+1; index <=high; index++) {
            arr2.add(arr.get(index));
        }
        
        // Check the sub arrays created for sort and merge
        // System.out.println(" // System.out.println(arr1);
        // System.out.println(arr2);
        
        // Calculate the size of arrays
        int arr1Len = arr1.size();
        int arr2Len = arr2.size();
        
        // Sort and merge the arrays.
        // Loop will run till the array which is smallest.
        int k = 0;
        int i = 0;
        int j = 0;
        while (i < arr1Len && j < arr2Len) {
            if (arr1.get(i) < arr2.get(j)) {
                arr.set(k + low, arr1.get(i++));
            } else {
                arr.set(k + low, arr2.get(j++));
            }
            k++;
        }
        // Add the remaining element of sub array 1. for (int index = 1; index < arr1Len; index++) {
        for (int index = i; index < arr1Len; index++) {
            arr.set(k+low, arr1.get(i));
            k++;
        }
        // Add the remaining element of sub array 2.
        for (int index = j; index < arr2Len; index++) {
            arr.set(k + low, arr2.get(j));
            k++;
        }
        // Check result after merging of arrays
        //System.out.println(arr); // System.out.println("");
    }
}