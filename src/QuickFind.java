/* Data structure : int array
   Cost : N^2
 */
import java.util.Scanner;
import java.io.*;
public class QuickFind {

    int[] id;
    public QuickFind(int N)
    {
        //Initializing
        id=new int[N];
        for(int i=0;i<N;i++)
            id[i]=i;
    }
    public boolean connected(int p, int q)
    {
        return id[p]==id[q];
    }
    public void union(int p,int q)
    {
        int pid=id[p];
        int qid=id[q];
        for(int i=0;i<id.length;i++)
        {
            if(id[i]==pid) id[i]=qid;
        }
        print();
    }
    public void print()
    {
        for(int i=0;i<id.length;i++)
            System.out.print(id[i]+"\t");
        System.out.println();

    }
    public static void main(String[] args)
    {
       QuickFind qf= new QuickFind(10);
       qf.print();
       qf.union(3,5);
       System.out.println(qf.connected(3,5));
       qf.union(6,5);
       qf.union(4,5);
    }
}
