// soal nomor 1
public class BarangRental07{
    String noTKNB;
    String namaKendaraan;
    String jenisKendaraan;
    int tahun;
    int biayaSewa;
    boolean isRented;

    public BarangRental07(String noTKNB, String namaKendaraan, String jenisKendaraan, int tahun, int biayaSewa) {
        this.noTKNB = noTKNB;
        this.namaKendaraan = namaKendaraan;
        this.jenisKendaraan = jenisKendaraan;
        this.tahun = tahun;
        this.biayaSewa = biayaSewa;
        this.isRented = false;
    }
}