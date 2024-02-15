import java.util.Scanner;
/**
 * perulangan07
 */
public class perulangan07 {

    public static void main(String[] args) {
        //untuk memasukkan inputan dari terminal
        Scanner scanner = new Scanner(System.in);

        //input nim
        System.out.print("Masukkan NIM (10 digit): ");
        String nim = scanner.nextLine();

        //mengambil dua digit terakhir dari NIM 
        int n = Integer.parseInt(nim.substring(nim.length() - 2));


        if (n < 10) {
            n += 10;
        }

        for (int i = 1; i <= n; i++) {
            if (i == 6 || i == 10) {
                continue;
            }
            else if (i % 2 != 0) {
                System.out.print("* ");
            }
            else {
                System.out.print(i + " ");
            }
        }
    }
}