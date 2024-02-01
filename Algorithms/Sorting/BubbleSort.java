import java.util.Arrays;

public class BubbleSort
{
	public static void main(String[] args) {
		int[] arr = {64, 34, 25, 12, 22, 11, 90};
		BubbleSort bs = new BubbleSort();
        bs.bubbleSort(arr);
        System.out.println (Arrays.toString (arr));
	}
	
	void bubbleSort(int[] arr) 
    {
        int arrLength = arr.length;
        boolean swapped;
        // loop to hold arr length need to traverse
        for (int currentLength = arrLength; currentLength > 0; currentLength--)
        {
            swapped = false;
            for (int index = 0; index < currentLength-1; index++)
            {
                if (arr[index] > arr[index + 1])
                {
                    int temp = arr[index];
                    arr[index] = arr[index + 1];
                    arr[index + 1] = temp;
                    swapped = true;
                }
	        }
	        if (!swapped) break;
        }   
    }
}
