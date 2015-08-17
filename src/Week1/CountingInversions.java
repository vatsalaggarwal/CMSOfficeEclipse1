package Week1;

public class CountingInversions {

	public static int CountInversions(int[] arr)
	{
		return CountInversions(arr, 0, arr.length - 1);
	}
	
	private static int CountInversions(int[] arr, int low, int high)
	{
		if (high - low > 0)
		{
			return CountInversions(arr, low, (low+high)/2) + CountInversions(arr, (low+high)/2 + 1, high)
				+ MergeAndCount(arr, low, (low+high/2), high);
		}
		else
			return 0;
	}
	
	private static int MergeAndCount(int[] arr, int low, int mid, int high)
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
	}
	
	public static void main(String[] args)
	{
		int[] arr = {5,6, 20, 10, 30};
		System.out.println(CountInversions(arr));
	}

}
