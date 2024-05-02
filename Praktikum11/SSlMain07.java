package Praktikum11;

public class SSlMain07 {
    public static void main(String[] args) {
        LinkedList07 myLinkedList07 = new LinkedList07();
        myLinkedList07.print();
        myLinkedList07.addFirst(800);
        myLinkedList07.print();
        myLinkedList07.addFirst(700);
        myLinkedList07.print();
        myLinkedList07.addLast(500);
        myLinkedList07.print();
        myLinkedList07.insertAfter(700, 300);
        myLinkedList07.print();

        System.out.println("Data pada index ke-1: " + myLinkedList07.getData(1));
        System.out.println("Data 300 berada pada index ke: " +myLinkedList07.indexof(300));

        myLinkedList07.remove(300);
        myLinkedList07.print();
        myLinkedList07.removeFirst();
        myLinkedList07.print();
        myLinkedList07.removeLast();
        myLinkedList07.print();

        myLinkedList07.addLast(100);
        myLinkedList07.addLast(200);
        myLinkedList07.addLast(300);
        myLinkedList07.addLast(400);
        myLinkedList07.addLast(500);
        System.out.println("Linked list awal:");
        myLinkedList07.removeFirst();
        myLinkedList07.print();
        myLinkedList07.insertBefore(300, 250);
        System.out.println("Linked list setelah insertBefore 300 dengan 250:");
        myLinkedList07.print();
        myLinkedList07.insertAt(2, 150);
        System.out.println("Linked list setelah insertAt index 2 dengan 150:");
        myLinkedList07.print();
        myLinkedList07.removeAt(3);
        System.out.println("Linked list setelah removeAt index 3:");
        myLinkedList07.print();
    }
}
