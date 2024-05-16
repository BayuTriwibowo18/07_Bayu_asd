package doublelinkedlists;
import java.util.Scanner;

import javax.sound.sampled.SourceDataLine;;
public class DoubleLikedListsMain07 {
    public static void main (String[] args) throws Exception { 
        Scanner sc07 = new Scanner(System.in);
        Doublelikendlists07 dll = new Doublelikendlists07();
        dll.print();
        System.out.println("size : "+dll.size());
        System.out.println("==================================");
        dll.addFirst(3);
        dll.addLast(4);
        dll.addFirst(7);
        dll.print();
        System.out.println("Size : "+dll.size());
        System.out.println("==================================");
        dll.add(40, 1);
        dll.print();
        System.out.println("Size : "+dll.size());
        System.out.println("==================================");
        dll.clear();
        dll.print();
        System.out.println("Size : "+dll.size() );
        dll.addLast(50);
        dll.addLast(40);
        dll.addLast(10);
        dll.addLast(20);
        dll.print();
        System.out.println("Size : "+dll.size());
        System.out.println("==================================");
        dll.removeFirst();
        dll.print();
        System.out.println("Size : "+dll.size());
        System.out.println("==================================");
        dll.removeLast();
        dll.print();
        System.out.println("Size : "+dll.size());
        System.out.println("==================================");
        dll.remove(1);
        dll.print();
        System.out.println("Size : "+dll.size());
        dll.clear();
        dll.print();
        System.out.println("Size : "+dll.size());
        System.out.println("==================================");
        dll.addFirst(3);
        dll.addLast(4);
        dll.addFirst(7);
        dll.print();
        System.out.println("Size : "+dll.size());
        System.out.println("==================================");
        dll.add(40, 1);
        dll.print();
        System.out.println("Size : "+dll.size());
        System.out.println("==================================");
        System.out.println("Data awal pada Linked Lists adalah : "+ dll.getFirst());
        System.out.println("Data akhir pada Linked Lists adalah : "+ dll.getLast());
        System.out.println("Data indeks ke-1 pada Linked Lists adalah : "+dll.get(1));
        

    }
}
