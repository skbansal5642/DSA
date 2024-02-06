import java.util.Arrays;

public class InsertionSort
{
	public static void main(String[] args) {
		int[] arr = { 4, 3, 2, 10, 12, 1, 5, 6 };
        InsertionSort is = new InsertionSort();
        is.insertionSort(arr);
        System.out.println (Arrays.toString (arr));
	}
	
	void insertionSort(int[] arr) 
  {
        int arrLength = arr.length;
        // first loop to go to end of array
        for (int currentIndex = 1; currentIndex < arrLength; currentIndex++)
        {
            int temp = arr[currentIndex];
            // Second loop will sort all elements after any swap
            int index = currentIndex - 1;
            while (index >=0 && arr[index] > temp)
            {
                arr[index+1] = arr[index];
                index--;
	        }
	        arr[index+1] = temp;
        }   
  }
}
