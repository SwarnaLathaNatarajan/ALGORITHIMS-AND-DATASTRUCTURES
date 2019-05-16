import java.util.Iterator;
import java.util.Scanner;

public class Deque<Item> implements Iterable<Item> {
    private Node<Item> first;
    private Node<Item> last;
    int size;
    private class Node<Item>
    {
        Item item;
        Node<Item> next;
        Node<Item> previous;
        public Node(Item item,Node<Item> next,Node<Item> previous)
        {
            this.item=item;
            this.next=next;
            this.previous=previous;
        }
    }
    public Deque()                           // construct an empty deque
    {
        size=0;
        first=null;
        last=null;
    }
    public boolean isEmpty()                 // is the deque empty?
    {
        return size==0;
    }
    public int size()                        // return the number of items on the deque
    {
        return size;
    }
    public void addFirst(Item item)          // add the item to the front
    {
        Node oldfirst=first;
        first=new Node(item,null,oldfirst);
        if(size!=0)
            oldfirst.previous=first;
        size++;
        if(size==1) last=first;
        print();
    }
    public void addLast(Item item)           // add the item to the end
    {
        Node oldlast=last;
        last=new Node(item,oldlast,null);
        if(size!=0)
            oldlast.next=last;
        size++;
        if(size==1) first=last;
        print();
    }
    public Item removeFirst()                // remove and return the item from the front
    {
        if(size!=0) {
            Item i = first.item;
            first = first.next;
            first.previous = null;
            size--;
            print();
            return i;
        }
        return null;
    }
    public Item removeLast()                 // remove and return the item from the end
    {
        if(size!=0) {
            Item i = last.item;
            last = last.previous;
            last.next = null;
            size--;
            print();
            return i;
        }
        return null;
    }
    public Iterator<Item> iterator()         // return an iterator over items in order from front to end
    {
        return new DequeIterator();
    }
    public class DequeIterator implements Iterator<Item>
    {
        private Node current=first;
        @Override
        public boolean hasNext() {
            return current!=null;
        }

        @Override
        public Item next() {
            Item i= (Item) current.item;
            current=current.next;
            return i;
        }

        @Override
        public void remove() {

        }
    }
    public void print()
    {
        System.out.println();
        Iterator<Item> i=this.iterator();
        while(i.hasNext())
        {
            Item s=i.next();
            System.out.print(s+" | ");
        }
    }
    public static void main(String[] args)   // unit testing (optional)
    {
        Deque<String> dq=new Deque<String>();
        Scanner s=new Scanner(System.in);
        int choice=0;
        String item;
        while(choice!=6)
        {
            System.out.println("1.AddFirst\t2.AddLast\t3.RemoveFirst\t4.RemoveLast\t5.Size\t6.Exit");
            choice=s.nextInt();
            switch (choice)
            {
                case 1:
                    System.out.println("Enter String to be added  : ");
                    item=s.next();
                    dq.addFirst(item);
                    break;
                case 2:
                    System.out.println("Enter String to be added  : ");
                    item=s.next();
                    dq.addLast(item);
                    break;
                case 3:
                    System.out.println("Removed : "+dq.removeFirst()); break;
                case 4:
                    System.out.println("Removed : "+dq.removeLast()); break;
                case 5:
                    System.out.println("Size : "+dq.size());
            }
        }
    }
}