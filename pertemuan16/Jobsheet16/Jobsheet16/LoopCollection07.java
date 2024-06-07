package Jobsheet16;

import java.util.Stack;
import java.util.Collections;
import java.util.Iterator;;
public class LoopCollection07 {
  
    public static void main(String[] args) {
        Stack<String> fruits = new Stack<>();
        fruits.push("Banana");
        fruits.add("Orange");
        fruits.add("Watermelon");
        fruits.add("Lechi");
        fruits.push("Salak");
        fruits.pop(); // Menghapus elemen terakhir dari stack
        fruits.push("Strawberry"); // Menambahkan "Strawberry" ke puncak stack
        fruits.push("Mango");
        fruits.push("guava");
        fruits.push("avocado");
        for (String fruit : fruits) {
            System.out.printf("%s ", fruit);
        }
        // Sorting elemen di dalam stack
        Collections.sort(fruits);

        // Mencetak elemen setelah sorting
        System.out.println("\nSetelah sorting:");
        for (String fruit : fruits) {
            System.out.printf("%s ", fruit);
        }       
        

        System.out.println("\n" + fruits.toString());

        while (!fruits.empty()) {
            System.out.printf("%s ", fruits.pop());
        }
        fruits.push("Melon");
        fruits.push("Durian");
        System.out.println("");
        for (Iterator<String> it = fruits.iterator(); it.hasNext();) {
            String fruit = it.next();
            System.out.printf("%s ", fruit);
        }
        System.out.println("");
        fruits.stream().forEach(e -> {
            System.out.printf("%s ", e);
        });
        System.out.println("");
        for (int i = 0; i < fruits.size(); i++) {
            System.out.printf("%s ", fruits.get(i));
        }
    }
}
