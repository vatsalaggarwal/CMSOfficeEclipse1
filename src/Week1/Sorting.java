
package Week1;
import java.util.Random;

/*
 * Merge Sort : Easier way to deal with the three conditions inside the loop, 
 * and how to do the "copy the test"
 * 
 * Quick Sort : Not much of an issue
 * 
 * Do we need to redefine variables inside the function while recursing?
 * Otherwise what would happen?
 * 
 */

public class Sorting {
// private static int leftArrayEnd;
	
	public static void MergeSort(int[] arr)
	{
		MergeSort(arr, 0, arr.length - 1);
	}
	
	private static void MergeSort(int[] arr, int low, int high)
	{
		//System.out.println(high);
		if(high - low > 0)
		{
			int leftArrayEnd = (low + high) / 2;  //I WILL NEED TO REDEFINE EVERY TIME RIGHT? WHY.
			MergeSort(arr, low, leftArrayEnd); //leftArrayEnd includes last element
			MergeSort(arr, leftArrayEnd + 1, high);
			//System.out.println(high);
			Merge(arr, low, leftArrayEnd, high);
		}
	}
	
	private static void Merge(int[] arr, int low, int leftArrayEnd, int high)
	{
		//printArray(arr);
		//System.out.println(high + "inside merge");
		int[] temp;
		int tempLength = high - low + 1;
		temp = new int[tempLength];
		int leftArrPos = low, rightArrPos = leftArrayEnd + 1;
		
		for  (int i = 0; i < tempLength; i++)
		{
		//	if(leftArrPos <= leftArrayEnd && rightArrPos <= high)
		//	{	
				if((rightArrPos > high || arr[leftArrPos] < arr[rightArrPos]) && leftArrPos <= leftArrayEnd)
				// why do I need the last condition as well? easier way to do this?
				{
					temp[i] = arr[leftArrPos++];
				}
				else
				{
					temp[i] = arr[rightArrPos++];
				}
//				printArray(temp);
		//	}
		//	else
		//	{
				
		//	}
		}
//		printArray(temp);
		
		
		for (int i = 0; i < tempLength; i++)
		{
			arr[low + i] = temp[i];
		}
		
	}
	

	private static void printArray(int[] arr)
	{
		for( int i : arr)
			System.out.print(i + " ");
		System.out.println();
	}
	

	public static void QuickSort(int[] arr)
	{
		QuickSort(arr, 0, arr.length - 1);
	}
	
	private static void QuickSort(int[] arr, int low, int high)
	{
		if(high - low > 0)
		{
			int pivot = ChoosePivot(arr, low, high);
			pivot = partition(arr, pivot, low, high);
			System.out.println(pivot);
			for( int i : arr)
				System.out.print(i + " ");
			System.out.println();
			QuickSort(arr, low, pivot - 1);
			QuickSort(arr, pivot + 1, high);
		}
	}
	
	private static int ChoosePivot(int[] arr, int low, int high)
	{
		Random rgen = new Random();
		return (rgen.nextInt(high - low + 1) + low);
	}
	
	private static int partition(int[] arr, int pivot, int low, int high)
	{
		swap(arr, low, pivot);
		
		pivot = low;
		int leftArrEnd = low + 1; //left part does not include this
		
		for (int i = (low + 1); i <= high; i++)
		{
			if (arr[i] < arr[pivot])
			{
				swap(arr, i, leftArrEnd++);
			}
		}
		
		swap(arr, pivot, leftArrEnd - 1);
		pivot = leftArrEnd - 1;
		
		return pivot;
	}
	
	private static void swap(int[] arr, int pos1, int pos2)
	{
		int temp = arr[pos1];
		arr[pos1] = arr[pos2];
		arr[pos2] = temp;
	}

	
	
	
	public static void main(String[] args)
	{
		int[] arr = {9, 5, 1, 25, 10 , 561 ,55 ,515,1534 ,231 ,521, 52, 0,11, 1, 5, 9};
		MergeSort(arr);
		//QuickSort(arr);
		printArray(arr);
		
	}


	

}
