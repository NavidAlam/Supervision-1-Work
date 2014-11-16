
public class Question4 {
	
	static int sum (int[] a) 
	{
		// creates a variable to hold the partial sum
		int pSum = 0;
		for(int i = 0; i < a.length; i++)
		{
			pSum += a[i];
		}
		
		return pSum;
	}
	
	static int[] cumsum(int[] a)
	{
		
		int len = a.length;
		int[] cumSums = new int[len];
		cumSums[0] = a[0];
		
		// sums using that cumulative sum of x elements = cumulative sum of x-1 elements + xth element
		for(int i = 1; i < len; i++)
		{
			cumSums[i] += a[i] + cumSums[i-1]; 
		}
		
		return cumSums;
	}
	
	static int[] positives(int a[])
	{
		int noOfPositives = 0;
		int len = a.length;
		
		// calculates the number of positives, to get the length of the array to be returned
		// this allows us to avoid using dynamic data types
		for(int i = 0; i < len; i++)
		{
			if(a[i] > 0) {noOfPositives++;}
		}
		
		int posArr[] = new int[noOfPositives];
		int index = 0;
		
		for(int i = 0; i < len; i++)
		{
			if(a[i] > 0)
			{
				posArr[index] = a[i];
				index++;
			}
		}
		
		return posArr;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
