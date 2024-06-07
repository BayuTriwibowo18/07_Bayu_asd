package Tugas;

public class Matakuliah07 {

    String kode;
    String nama;
    int sks;

    public Matakuliah07(String kode, String nama, int sks) {
        this.kode = kode;
        this.nama = nama;
        this.sks = sks;
    }
    public String getMatkul() {
        return nama;
    }
    public int getSks() {
        return sks;
    }
    @Override
    public String toString() {
        return kode + "    " + nama + "    " + sks;
    }
}
 
