package Tugas;

public class Nilai07 implements Comparable<Nilai07> {
    Mahasiswa07 mahasiswa;
    Matakuliah07 matkul;
    double nilai;

    public Nilai07(Mahasiswa07 mahasiswa, Matakuliah07 matkul, double nilai) {
        this.mahasiswa = mahasiswa;
        this.matkul = matkul;
        this.nilai = nilai;
    }

    public Mahasiswa07 getMahasiswa() {
        return mahasiswa;
    }

    @Override
    public String toString() {
        return String.format("%-10s %-15s %-30s %-5d %-5.2f", mahasiswa.getNim(), mahasiswa.getNama(), matkul.getMatkul(), matkul.getSks(), nilai);
    }

    @Override
    public int compareTo(Nilai07 other) {
        return Double.compare(this.nilai, other.nilai);
    }
}
