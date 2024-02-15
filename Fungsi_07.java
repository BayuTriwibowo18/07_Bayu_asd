import java.util.Locale;

public class Fungsi_07 {
    public static void main(String[] args) {
        int bunga[][] = {
            {10,5,15,7},
            {6,11,9,12},
            {2,10,10,5},
            {5,7,12,9}
        };
        int harga[] = {75000,50000,60000,10000};
        pendapatan(bunga, harga);
        stock(bunga);
        pengurangan(bunga);
    }
    static void pendapatan(int bunga[][], int harga[]){
        int totPendapatan = 0;
        for(int i = 0; i < bunga.length; i++){
            for(int j = 0; j < bunga[i].length; j++){
                totPendapatan += bunga[i][j] * harga[j];
            }
            System.out.println("Pendapatan RoyalGarden "+(i+1)+" adalah: Rp. " + totPendapatan);
        }
        System.out.println("========================================================");
    }
    static void stock(int bunga[][]){
        for(int i = 0; i < bunga.length; i++){
            System.out.print("Stock RoyalGarden "+(i+1)+": ");
            for(int j = 0; j < bunga[i].length; j++){
                System.out.print(bunga[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("========================================================");
    }
    static void pengurangan(int bunga[][]){
        for(int i = 0; i < bunga.length; i++){
            System.out.print("Stock RoyalGarden "+(i+1)+" setelah pengurangan stok: ");
            for(int j = 0; j < bunga[i].length; j++){
                if(j == 0){
                    bunga[i][j] -= 1;
                }else if(j == 1){
                    bunga[i][j] -= 2;
                }
                else if(j == 3){
                    bunga[i][j] -= 5;
                }
                System.out.print(bunga[i][j] + " ");
            }
            System.out.println();
        }
    }
}