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

    void insertionSort1(int[] arr) 
  {
        int arrLength = arr.length;
        // first loop to go to end of array
        for (int currentIndex = 0; currentIndex < arrLength - 1; currentIndex++)
        {
            if (arr[currentIndex] > arr[currentIndex + 1])
            {
                int temp = arr[currentIndex];
                arr[currentIndex] = arr[currentIndex + 1];
                arr[currentIndex + 1] = temp;
                
                // Second loop will sort all elements after any swap
                for (int index = currentIndex; index > 0; index--)
                {
                    if (arr[index] < arr[index - 1])
                    {
                        temp = arr[index];
                        arr[index] = arr[index - 1];
                        arr[index - 1] = temp;
                    } else {
                        break;
                    }
    	        }
            }
        }   
  }
}
