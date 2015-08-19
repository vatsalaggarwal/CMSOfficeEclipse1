package Week1;
import java.util.Scanner;
import java.io.File;

public class CountingInversions {

	public static long CountInversions(int[] arr)
	{
		return CountInversions(arr, 0, arr.length - 1);
	}
	
	private static long CountInversions(int[] arr, int low, int high)
	{
		if (high - low > 0)
		{
			long a = CountInversions(arr, low, (low+high)/2);
			long b = CountInversions(arr, (low+high)/2 + 1, high);
			long c = MergeAndCount(arr, low, (low+high)/2, high);
			return a + b + c;
		}
		else
			return 0;
	}
	
/*	private static int MergeAndCount(int[] arr, int low, int mid, int high)
	{
		int[] temp;
		int tempLength = high - low + 1;
		temp = new int[tempLength];
		int leftArrPos = low, rightArrPos = mid + 1;
		int toReturn = 0;
		
		for  (int i = 0; i < tempLength; i++)
		{

				if((rightArrPos > high || arr[leftArrPos] < arr[rightArrPos]) && leftArrPos <= mid)
				{
					temp[i] = arr[leftArrPos++];
				}
				else if(arr[leftArrPos] <= arr[rightArrPos])
				{
					temp[i] = arr[rightArrPos];
					//if(arr[leftArrPos]>=arr[rightArrPos])
					toReturn++; //why does this work?
				}
//			
		}
		
		return toReturn;
	}*/
	
	private static long MergeAndCount(int[] arr, int low, int mid, int high)
	{
		int[] arr1 = copyArray(arr,low,mid);
		int[] arr2 = copyArray(arr,mid+1,high);
		
		long toReturn = 0;
		int arr1Len = mid - low + 1;
		int arr2Len = high - mid;
		
		int loopLen = high - low + 1;
		int j = 0, k = 0, i = 0;
		
		
		while ( j < arr1Len && k < arr2Len)
		{
			if(arr1[j] < arr2[k])
			{
				arr[low + i] = arr1[j++];
				i++;
			}
			else
			{
				arr[low + i] = arr2[k++];
				toReturn += mid - (low + j) + 1; //NOTE ITS LOW + J
				i++;
			}
		}
		
		while ( i < loopLen)
		{
			if( j < arr1Len )
			{
				arr[low + i++] = arr1[j++];
			}
			else if( k < arr2Len )
			{
				arr[low + i++] = arr2[k++];
			}
		}
		
		return toReturn;
		
	}
	
	private static void printArray(int[] arr)
	{
		for(int i : arr)
			System.out.print(i + " ");
		System.out.println();
	}
	
	private static int[] copyArray(int[] arr, int start, int end)
	{
		int returnArrLength = end-start+1;
		int[] toReturn = new int[returnArrLength];
		
		for(int i = 0; i < (returnArrLength); i++)
		{
			toReturn[i] = arr[start + i];
		}
		
		return toReturn;
	}
	
	public static void main(String[] args) throws Exception
	{
		
		int[] arr;
		Scanner filescanner = new Scanner(new File("/home/vis-176/Downloads/IntegerArray.txt"));
		arr = new int[100000];
		System.out.println(arr[99999]);
		for(int i = 0; i < 100000; i++)
		{
			arr[i] = filescanner.nextInt();
		}
		
		System.out.println(CountInversions(arr));
		filescanner.close();
		//printArray(arr);
	}

}
