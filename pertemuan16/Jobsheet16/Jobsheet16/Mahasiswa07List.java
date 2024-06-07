package Jobsheet16;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Mahasiswa07List {
    List<Mahasiswa07> Mahasiswa07s = new ArrayList<>();

    public void tambah(Mahasiswa07... Mahasiswa07) {
        Mahasiswa07s.addAll(Arrays.asList(Mahasiswa07));
    }

    public void hapus(int index) {
        Mahasiswa07s.remove(index);
    }

    public void update(int index, Mahasiswa07 mhs) {
        Mahasiswa07s.set(index, mhs);
    }

    public void tampil() {
        Mahasiswa07s.stream().forEach(mhs -> {
            System.out.println("" + mhs.toString());
        });
    }

    // // int linearSearch(String nim) {
    // //     for (int i = 0; i < Mahasiswa07s.size(); i++) {
    // //         if (nim.equals(Mahasiswa07s.get(i).nim)) {
    // //             return i;
    // //         }
    // //     }
    // //     return -1;
    // }

    int binarySearch(String nim) {
        Collections.sort(Mahasiswa07s, Comparator.comparing(m -> m.nim));
        int index = Collections.binarySearch(Mahasiswa07s, new Mahasiswa07(nim, null, null),
                Comparator.comparing(m -> m.nim));
        return index;
    }
    public void sortAscending() {
        Collections.sort(Mahasiswa07s, Comparator.comparing(Mahasiswa07::getNim));
    }

    public void sortDescending() {
        Collections.sort(Mahasiswa07s, Comparator.comparing(Mahasiswa07::getNim).reversed());
    }
    public static void main(String[] args) {
        Mahasiswa07List lm = new Mahasiswa07List();
        Mahasiswa07 m = new Mahasiswa07("201234", "Noureen", "021xx1");
        Mahasiswa07 m1 = new Mahasiswa07("201235", "Akhleema", "021xx2");
        Mahasiswa07 m2 = new Mahasiswa07("201236", "Shannum", "021xx3");

        lm.tambah(m, m1, m2);
        lm.tampil();
        lm.sortAscending();
        System.out.println("Sorted Ascending:");
        lm.tampil();
        lm.sortDescending();
        System.out.println("Sorted Descending:");
        lm.tampil();
        // int index = lm.binarySearch("201235");
        // if (index >= 0) {
        //     lm.update(index, new Mahasiswa0707("201235", "Akhleena Lela", "021xx2"));
        // }
        // System.out.println("");
        // lm.tampil();
    }
}