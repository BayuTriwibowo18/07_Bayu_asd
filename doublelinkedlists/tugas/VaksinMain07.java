package doublelinkedlists.tugas;

import java.util.Scanner;

public class VaksinMain07 {
     public static void main(String[] args) {
        VaksinQueue07 queue = new VaksinQueue07();
        Scanner sc15 = new Scanner(System.in);
        int menu;

        do {
            System.out.println("-----------------------------");
            System.out.println("PENGANTRI VAKSIN BAROKAH");
            System.out.println("-----------------------------");
            System.out.println("1. Tambah Data Penerima Vaksin");
            System.out.println("2. Hapus Data Pengantri Vaksin");
            System.out.println("3. Daftar Penerima Vaksin");
            System.out.println("4. Keluar");
            System.out.println("------------------------------");
            System.out.print("Masukkan pilihan: ");
            menu = sc15.nextInt();
            sc15.nextLine();

            switch (menu) {
                case 1:
                System.out.println("-----------------------------");
                System.out.println("Masukkan Data Penerima Vaksin");
                System.out.println("-----------------------------");
                System.out.print("Masukkan nomor antrian: ");
                String nomorAntrian = sc15.next();
                System.out.print("Masukkan nama penerima: ");
                String nama = sc15.next();
                queue.add(nama, nomorAntrian);
                break;
                case 2:
                queue.remove();
                break;
                case 3:
                queue.printQueue();
                break;
                case 4:
                System.out.println("Keluar dari program.");
                break;
                default:
                System.out.println("Opsi tidak valid. Silakan coba lagi.");
                break;
            }
        } while (menu != 5);
    }
}
