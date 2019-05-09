import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import java.io.*;
import java.util.Arrays;

public class Percolation {
    public boolean[][] grid;
    public static int n=4;
    public WeightedQuickUnionUF uf=new WeightedQuickUnionUF(n*n);
    public Percolation(int n)                // create n-by-n grid, with all sites blocked
    {
        grid=new boolean[n][n];
    }
    public void open(int row, int col)    // open site (row, col) if it is not open already
    {
        grid[row][col]=true;
        int i=row*n+col;
        if(row+1<n && grid[row+1][col])  uf.union((row+1)*n+col,i);
        else if(col+1<n && grid[row][col+1]) uf.union(i,row*n+col+1);
        else if(row-1>=0 && grid[row-1][col])  uf.union(i,(row-1)*n+col);
        else if(col-1>=0 && grid[row][col-1]) uf.union(i,row*n+col-1);
        print();
    }
    public boolean isOpen(int row, int col)  // is site (row, col) open?
    {
        return grid[row][col];
    }
    public boolean isFull(int row, int col)  // is site (row, col) full?
    {
        int i=row*n+col;
        boolean result=false;
        for(int j=0;j<n;j++)
            result=result || uf.connected(i,j);
        return result;
    }
    public int numberOfOpenSites()       // number of open sites
    {
        return Arrays.deepToString(grid).replaceAll("[^t]", "").length();
    }
    public boolean percolates()              // does the system percolate?
    {
        boolean result=false;
        for(int i=0;i<n;i++)
            result=result || isFull(n-1,i);
        return result;
    }
    public void print()
    {
        System.out.println("----------------------");
        for(int i=0;i<n;i++)
        {
            System.out.println();
            for(int j=0;j<n;j++)
                System.out.print(grid[i][j]+"\t");
        }
    }
    public static void main(String[] args)   // test client (optional)
    {
        Percolation p=new Percolation(n);
        p.print();
        p.open(0,0);p.open(1,0);p.open(1,1);p.open(2,1);p.open(3,1);
        System.out.println("isFull of 1,1 : "+p.isFull(1,1));
        System.out.println("NoOfOpenSites : "+p.numberOfOpenSites());
        System.out.println("Percolates : "+p.percolates());
    }
}
