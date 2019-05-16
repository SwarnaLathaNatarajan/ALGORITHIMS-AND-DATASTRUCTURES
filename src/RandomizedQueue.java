import org.omg.CORBA.Object;

import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class RandomizedQueue<Item>  {
    private Item[] items;
    private int size,head,tail;
    Random random=new Random();
    public RandomizedQueue(int capacity)                 // construct an empty randomized queue
    {
        items=(Item[])new Object[capacity];
        size=0;
    }
    public boolean isEmpty()                 // is the randomized queue empty?
    {
        return size==0;
    }
    public int size()                        // return the number of items on the randomized queue
    {
        return size;
    }
    public void resize(int n)
    {
        Item[] copy=(Item[])new Object[n];
        for(int i=0;i<items.length;i++)
            copy[i]=items[i];
        items=copy;
    }
    public void rearrange(int x)
    {
        for(int i=x;i<size-1;i++)
        {
            items[i]=items[i+1];
        }
    }
    public void enqueue(Item item)           // add the item
    {
        if(size==items.length) resize(2*items.length);
        items[size]=item;
        size++;
        print();
    }
    public Item dequeue()                    // remove and return a random item
    {
        if(size>0 && size==items.length/4) resize(items.length/2);
        int rand=random.nextInt(size);
        Item i=items[rand];
        rearrange(rand);
        print();
        return i;
    }
    public Item sample()                     // return a random item (but do not remove it)
    {
        return items[random.nextInt(size)];
    }
    public void print()
    {
        System.out.println();
        for(int i=0;i<size;i++)
        {
            System.out.print(items[i]+" | ");
        }
        System.out.println();
    }
    public static void main(String[] args)   // unit testing (optional)
    {
        RandomizedQueue<String> rq=new RandomizedQueue<>(3);
        Scanner s=new Scanner(System.in);
        int choice=0;
        String item;
        while(choice!=5)
        {
            System.out.println("1.Enqueue\t2.Dequeue\t3.Sample\t4.Size\t5.Exit");
            choice=s.nextInt();
            switch (choice)
            {
                case 1:
                    System.out.println("Enter String to be added  : ");
                    item=s.next();
                    rq.enqueue(item);
                    break;
                case 2:
                    System.out.println("Dequeued : "+rq.dequeue());
                    break;
                case 3:
                    System.out.println("Sample : "+rq.sample()); break;
                case 4:
                    System.out.println("Size : "+rq.size()); break;
            }
        }
    }
}