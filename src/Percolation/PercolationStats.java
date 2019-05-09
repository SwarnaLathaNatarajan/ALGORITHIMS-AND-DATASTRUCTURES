package Percolation;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private int N,T;
    private double[] x;
    private Percolation p;
    public PercolationStats(int n, int trials)    // perform trials independent experiments on an n-by-n grid
    {
        N=n;
        T=trials;
        x=new double[T];
        for(int i=0;i<T;i++)
        {
            p=new Percolation(n);
            while(!p.percolates())
            {
                p.open(StdRandom.uniform(n),StdRandom.uniform(n));
            }
            x[i]=(double)p.numberOfOpenSites()/(n*n);
        }
    }
    public double mean()                          // sample mean of percolation threshold
    {
        return StdStats.mean(x);
    }
    public double stddev()                        // sample standard deviation of percolation threshold
    {
        return StdStats.stddev(x);
    }
    public double confidenceLo()                  // low  endpoint of 95% confidence interval
    {
        return StdStats.mean(x)-1.96*StdStats.stddev(x)/Math.sqrt(T);
    }
    public double confidenceHi()                  // high endpoint of 95% confidence interval
    {
        return StdStats.mean(x)+1.96*StdStats.stddev(x)/Math.sqrt(T);
    }

    public static void main(String[] args)        // test client (described below)
    {
        PercolationStats ps=new PercolationStats(Integer.parseInt(args[0]),Integer.parseInt(args[1]));
        System.out.println("Mean : "+ps.mean());
        System.out.println("Standard Deviation : "+ps.stddev());
        System.out.println("Confidence Interval : [ "+ps.confidenceLo()+" , "+ps.confidenceHi()+" ] ");
    }
}