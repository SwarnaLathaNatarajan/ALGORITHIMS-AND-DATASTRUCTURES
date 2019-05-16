import java.util.Scanner;

public class StackLinkedlist {
    private Node first=null;
    private class Node
    {
        String item;
        Node next;
    }
    private boolean isEmpty()
    {
        return first==null;
    }
    private void push(String item)
    {
        Node oldfirst=first;
        first=new Node();
        first.item=item;
        first.next=oldfirst;
        print();
    }
    private String pop()
    {
        String s=first.item;
        first=first.next;
        print();
        return s;
    }
    private void print()
    {
        Node temp = first;
        System.out.println(temp.item + " | ");
        while (temp.next != null) {
            temp = temp.next;
            System.out.print(temp.item + " | ");
        }
        System.out.println();

    }
    public static void main(String[] arg)
    {
        StackLinkedlist stack=new StackLinkedlist();
        Scanner s=new Scanner(System.in);
        int choice=0;
        String item;
        while(choice!=4)
        {
            System.out.println("1. Push\t2. Pop\t3. IsEmpty\t4. Exit");
            choice=s.nextInt();
            switch (choice)
            {
                case 1:
                    System.out.println("Enter String to be pushed  : ");
                    item=s.next();
                    stack.push(item);
                    break;
                case 2:
                    System.out.println("Popped : "+stack.pop()); break;
                case 3:
                    System.out.println(stack.isEmpty());
            }
        }
    }
}
