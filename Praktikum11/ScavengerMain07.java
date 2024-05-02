package Praktikum11;
import java.util.Scanner;
public class ScavengerMain07 {
    public static void main(String[] args) {
        ScavengerHunt07 game = new ScavengerHunt07();
        game.addPoint("Apa ibukota Indonesia?", "Jakarta");
        game.addPoint("2 + 2 berapa?", "4");
        game.addPoint("Berapa jumlah prodi di jurusan JTI?", "2");
        game.addPoint("Siapa nama pacar bayu triwibowo?", "Arellia");

        game.displayPoints();

        Scanner sc07 = new Scanner(System.in);
        while (game.head != null) {
            System.out.print("Jawab: ");
            String answer = sc07.nextLine();
            if (game.checkAnswer(answer)) {
                System.out.println("Jawaban benar! Lanjut ke point berikutnya.");
            } else {
                System.out.println("Jawaban salah. Coba lagi.");
            }
        }
        System.out.println("Selamat! Anda telah menyelesaikan game.");
        sc07.close();
        System.exit(0);
    }
}
