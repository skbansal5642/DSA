import java.util.Arrays;


public class SelectionSort
{
  public static void main (String[]args)
  {
    int[] arr = { 65, 25, 12, 22, 11 };
    SelectionSort ss = new SelectionSort();
    ss.selectionSort(arr);
    System.out.println (Arrays.toString (arr));
  }
  
  void selectionSort(int[] arr) 
  {
        int arrLength = arr.length;
        // loop to hold minimum index
        for (int currentIndex = 0; currentIndex < arrLength; currentIndex++)
        {
            int minValIndex = currentIndex;
            for (int index = currentIndex + 1; index < arrLength; index++)
            {
                if (arr[index] < arr[minValIndex])
                {
                    minValIndex = index;
                }
	        }
            if (minValIndex != currentIndex)
            {
                int temp = arr[minValIndex];
                arr[minValIndex] = arr[currentIndex];
                arr[currentIndex] = temp;
            }
        }   
  }
}
