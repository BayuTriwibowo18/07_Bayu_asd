package Jobsheet9.postfix;
import java.util.Scanner;
public class PostfixMain {
    public static void main(String[] args) {
        Scanner sc07 = new Scanner(System.in);
        String p,Q;
        System.out.println("Masukkan ekspresi matematika (infix): ");
        Q = sc07.nextLine();
        Q = Q.trim();
        Q = Q + ")";
        
        int total = Q.length();

        Postfix07 post = new Postfix07(total);
        p = post.konversi(Q);
        System.out.println("Postfix: "+p);

    }
    
    


    
}
