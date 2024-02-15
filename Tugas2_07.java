import java.util.Scanner;

public class Tugas2_07 {

    // fungsi untuk menghitung kecepatan
    public static void hitungKecepatan() {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan jarak (Km): ");
        double s = input.nextDouble();
        
        System.out.print("Masukkan waktu (jam): "); 
        double t = input.nextDouble();
        
        double v = s / t;
        System.out.println("Kecepatan adalah " + v + " Km/jam");
    }
    
    // fungsi untuk menghitung jarak
    public static void hitungJarak() {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan kecepatan (Km/jam): ");
        double v = input.nextDouble();
        
        System.out.print("Masukkan waktu (jam): ");
        double t = input.nextDouble();
        
        double s = v * t;
        System.out.println("Jarak adalah " + s + " Km");
    }
    
    // fungsi untuk menghitung waktu
    public static void hitungWaktu() {
        Scanner input = new Scanner(System.in); 
        System.out.print("Masukkan jarak (Km): ");
        double s = input.nextDouble();
        
        System.out.print("Masukkan kecepatan (km/jam): ");
        double v = input.nextDouble();
        
        double t = s / v;
        System.out.println("Waktu adalah " + t + " jam");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Pilihan rumus:");
        System.out.println("1. Kecepatan");
        System.out.println("2. Jarak");
        System.out.println("3. Waktu");
        
        System.out.print("Masukkan pilihan: ");
        int pilihan = input.nextInt();
        
        if(pilihan == 1) {
            hitungKecepatan();
        } else if(pilihan == 2) {
            hitungJarak();
        } else if(pilihan == 3) {
            hitungWaktu();
        } else {
            System.out.println("Pilihan tidak valid");
        }
    }
}