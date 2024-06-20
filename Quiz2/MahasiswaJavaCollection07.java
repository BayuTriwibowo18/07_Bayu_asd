import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MahasiswaJavaCollection07 {
    private ArrayList<Mahasiswa07> list;

    public MahasiswaJavaCollection07() {
        list = new ArrayList<>();
    }

    public void add(Mahasiswa07 data) {
        list.add(data);
    }

    public void delete(String nim) {
        list.removeIf(mhs -> mhs.nim.equals(nim));
    }

    public Mahasiswa07 search(String nim) {
        for (Mahasiswa07 mhs : list) {
            if (mhs.nim.equals(nim)) {
                return mhs;
            }
        }
        return null;
    }

    public void sort() {
        Collections.sort(list, Comparator.comparing(mhs -> mhs.nim));
    }

    public void printAll() {
        System.out.println("+------+----------------+--------------+");
        System.out.println("| NIM  | Nama           | Tgl Lahir    |");
        System.out.println("+------+----------------+--------------+");
        for (Mahasiswa07 mhs : list) {
            System.out.format("| %-4s | %-14s | %-12s |%n", mhs.nim, mhs.nama, mhs.tglLahir);
        }
        System.out.println("+------+----------------+--------------+");
    }
}
