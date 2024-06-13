// soal nomor 1
public class TransaksiRental07 {
    static class TransaksiRental {
        private static int currentKodeTransaksi = 1;
        int kodeTransaksi;
        String namaPeminjam;
        int lamaPinjam;
        double totalBiaya;
        BarangRental07 br;

        TransaksiRental(String namaPeminjam, int lamaPinjam, double totalBiaya, BarangRental07 br) {
            this.kodeTransaksi = currentKodeTransaksi++;
            this.namaPeminjam = namaPeminjam;
            this.lamaPinjam = lamaPinjam;
            this.totalBiaya = totalBiaya;
            this.br = br;
        }
    }
}
