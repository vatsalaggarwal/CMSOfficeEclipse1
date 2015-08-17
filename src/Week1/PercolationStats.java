package Week1;

public class PercolationStats {
	Percolation[] perc;
	
	public PercolationStats(int N, int T)
	{
		if (N <= 0 || T <= 0)
			throw new java.lang.IllegalArgumentException();
		
		perc = new Percolation[T];
		for (int i = 0; i < T; i++)
		{
			perc[i] = new Percolation(N);
		}
		
		int n = StdRandom.uniform(0,5);
		
	}
	
	public double mean()
	{
		return 0;
	}
	
	public double stddev()
	{
		return 0;
	}
	
	public double confidenceLo()
	{
		return 0;
	}
	
	public double confidenceHi()
	{
		return 0;
	}
	
	public static void main(String[] args)
	{
		PercolationStats stats = new PercolationStats(Integer.parseInt(args[0]),Integer.parseInt(args[1]));
		System.out.println("mean = " + stats.mean());
		System.out.println("stddev = " + stats.stddev());
		System.out.println("95% confidence interval = " + stats.confidenceLo() + ", " +stats.confidenceHi());
	}
	
}
