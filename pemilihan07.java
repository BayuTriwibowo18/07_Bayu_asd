import java.util.Scanner;
/**
 * pemilihan07
 */
public class pemilihan07 {
    public static void main(String[] args) {
        //untuk memasukkan inputan dari terminal
        Scanner input07 = new Scanner(System.in);

        System.out.println("Program Menghitung Nilai Akhir"); 
        System.out.println("=============================="); 

        //input nilai
        System.out.print("Nilai Tugas (0-100): ");
        double tugas = input07.nextFloat();
        System.out.print("Nilai Kuis (0-100): ");
        double kuis = input07.nextFloat();
        System.out.print("Nilai UTS (0-100): ");
        double uts = input07.nextFloat();
        System.out.print("Nilai UAS (0-100): ");
        double uas = input07.nextFloat();

        System.out.println("=============================="); 

        //membuat pemilihan untuk input nilai sesuai (0-100)
        if (tugas < 100 && kuis < 100 && uts < 100 && uas < 100) {

            //menghitung rata rata nilai akhir
            double nilaiakhir = (tugas * 0.2) + (kuis * 0.2) + (uts * 0.3) + (uas * 0.3);

            //menampilkan angka dari Nilai Akhir
            System.out.println("Nilai Akhir: " + nilaiakhir);
            
            //menampilkan Nilai Akhir sesuai dengan predikat
            if (nilaiakhir > 80 && nilaiakhir <=100)
                System.out.println("Nilai Huruf: A");
            else if (nilaiakhir > 73 && nilaiakhir <=80)
                System.out.println("Nilai Huruf: B+");
            else if (nilaiakhir > 65 && nilaiakhir <=73)
                System.out.println("Nilai Huruf: B");
            else if (nilaiakhir > 60 && nilaiakhir <=65)
                System.out.println("Nilai Huruf: C+");
            else if (nilaiakhir > 50 && nilaiakhir <=60)
                System.out.println("Nilai Huruf: C");
            else if (nilaiakhir > 39 && nilaiakhir <=50)
                System.out.println("Nilai Huruf: D");
            else
                System.out.println("Nilai Huruf: E");

            //penyeleksian nilai lulus atau tidak
            String pesan = nilaiakhir < 50 ? "MOHON MAAF ANDA TIDAK LULUS" : "SELAMAT ANDA LULUS";
            System.out.println(pesan);

            }else { 
        
        //apabila nilai inputan tidak sesuai
        System.out.println("Nilai Tidak Valid!"); 
        } 
        System.out.println("=============================="); 
        System.out.println("=============================="); 
    }
}