public class QuickUnion {
    private int[] id;
    public QuickUnion(int N)
    {
        id=new int[N];
        for(int i=0;i<N;i++) id[i]=i;
    }
    public int root(int i)
    {
        while(i!=id[i]) i=id[i];
        return i;
    }
    public void union(int p,int q)
    {
        int rootp=root(p);
        int rootq=root(q);
        id[rootp]=rootq;
        print();
    }
    public boolean connected(int p,int q)
    {
        return root(p)==root(q);
    }
    public void print()
    {
        for(int i=0;i<id.length;i++)
            System.out.print(id[i]+"\t");
        System.out.println();

    }
    public static void main(String[] args)
    {
        QuickUnion qu=new QuickUnion(10);
        qu.print();
        qu.union(4,3);
        qu.union(3,8);
        qu.union(6,5);
        qu.union(9,4);
        System.out.println(qu.connected(4,9));
    }
}
