package Jobsheet9.pakaian;
import java.util.Scanner;
public class StackMain {
    public static void main(String[] args) {
        Scanner sc07 = new Scanner(System.in);
        Stack07 stk = new Stack07(5);
        char pilih = 'y';
        while (pilih == 'y') {
            System.out.println("\nMenu:");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Print");
            System.out.println("5. Keluar");
            System.out.print("Pilih operasi (1-5): ");
            int menu = sc07.nextInt();
            sc07.nextLine();

            switch (menu) {
                case 1:
                    System.out.print("Jenis: ");
                    String jenis = sc07.nextLine();
                    System.out.print("Warna: ");
                    String warna = sc07.nextLine();
                    System.out.print("Merk: ");
                    String merk = sc07.nextLine();
                    System.out.print("Ukuran: ");
                    String ukuran = sc07.nextLine();
                    System.out.print("Harga: ");
                    double harga = sc07.nextDouble();
                    sc07.nextLine();
                    Pakaian07 p = new Pakaian07(jenis, warna, merk, ukuran, harga);
                    stk.push(p);
                    break;
                case 2:
                    stk.pop();
                    break;
                case 3:
                    stk.peek();
                    break;
                case 4:
                    stk.print();
                    break;
                case 5:
                    System.out.println("Keluar dari program.");
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
            
            System.out.print("\nApakah anda ingin melanjutkan (y/n) ? ");
            pilih = sc07.next().charAt(0);
            sc07.nextLine();
        }
    }
}